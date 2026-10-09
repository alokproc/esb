package com.ssfb.account.service;

import com.ssfb.account.config.AccountConfig;
import com.ssfb.account.dto.rrninquiry.source.RRNInquirySourceRequestBody;
import com.ssfb.account.dto.rrninquiry.source.RRNInquirySourceResponse;
import com.ssfb.account.dto.rrninquiry.source.RRNInquirySourceResponseBody;
import com.ssfb.account.dto.rrninquiry.target.*;
import com.ssfb.commonmodule.dto.Error;
import com.ssfb.commonmodule.dto.fixml.CommonHeaders;
import com.ssfb.commonmodule.dto.fixml.MessageKey;
import com.ssfb.commonmodule.dto.fixml.RequestHeader;
import com.ssfb.commonmodule.dto.fixml.RequestMessageInfo;
import com.ssfb.commonmodule.utils.ErrorUtils;
import com.ssfb.commonmodule.utils.HttpRequestUtils;
import com.ssfb.logging.model.*;
import com.ssfb.logging.service.LoggingService;
import jakarta.validation.Valid;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.StringReader;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static com.ssfb.account.dto.Constants.*;

@Service
public class BrdRrnInquiryService {
    private final RestTemplate restTemplate;

    @Autowired
    private AccountConfig config;

    @Autowired
    private HttpRequestUtils requestUtils;

    private final LoggingService logging = new LoggingService();

    @Autowired
    public BrdRrnInquiryService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public RRNInquirySourceResponse rrnInquiry(@Valid RRNInquirySourceRequestBody requestBody, String correlationId, String requestId) throws Exception {
        RRNInquirySourceResponse response = new RRNInquirySourceResponse();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        try{
            RrnInquiryFixml fixml = prepareTargetRequestXml(requestBody.getRrn(), correlationId, requestId);

            logging.log(new LogEnvelope(new LogHeader("Account","RRNInquiry","RRNInquiry","RRNInquiry","01","OTHER","IN","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null,  "API Request is: "+ requestUtils.writeValueAsString(fixml))));
            ResponseEntity<String> responseEntity = restTemplate.exchange(rrnInquiryURIBuilder(), HttpMethod.POST, new HttpEntity<>(fixml, headers), String.class);

            logging.log(new LogEnvelope(new LogHeader("Account","RRNInquiry","RRNInquiry","RRNInquiry","01","OTHER","OUT","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null, "API Response is: "+ requestUtils.writeValueAsString(responseEntity.getBody()))));

            RrnInquiryFixml targetResponse = unmarshalXML(responseEntity.getBody());
            response = sourceResponseConverter(targetResponse);
            logging.log(new LogEnvelope(new LogHeader("Account","RRNInquiry","RRNInquiry","RRNInquiry","01","END","OUT","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null, "API Response is: "+ requestUtils.writeValueAsString(response))));
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            String extractedFixmlErrorMessage = ErrorUtils.extractXmlErrorString(e.getMessage());
            if(extractedFixmlErrorMessage != null){
                RrnInquiryFixml targetError = unmarshalXML(extractedFixmlErrorMessage);
                response.setError(ErrorUtils.extractError(targetError, RrnInquiryFixml::getBody, RrnInquiryBody::getError));
            } else {
                response.setError(new Error(EXCEPTION_ERR_CODE, EXCEPTION_ERR_DESC_TECH));
            }
            logging.log(new LogEnvelope(new LogHeader("Account","RRNInquiry","RRNInquiry","RRNInquiry","01","OTHER","OUT","ERROR","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(new ErrorDetail("01","","",new ErrorDescription(e.getLocalizedMessage(),"01", Arrays.toString(e.getStackTrace())),new ProcessContext("rrnInquiry","Test")), "API Response is: "+ requestUtils.writeValueAsString(response))));
        } catch (Exception e) {
            response.setError(new Error(EXCEPTION_ERR_CODE, EXCEPTION_ERR_DESC_GEN));
            logging.log(new LogEnvelope(new LogHeader("Account","RRNInquiry","RRNInquiry","RRNInquiry","01","OTHER","OUT","ERROR","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(new ErrorDetail("01","","",new ErrorDescription(e.getLocalizedMessage(),"01", Arrays.toString(e.getStackTrace())),new ProcessContext("rrnInquiry","Test")), "API Response is: "+ requestUtils.writeValueAsString(response))));
        }
        return response;
    }

    private URI rrnInquiryURIBuilder() {
        return UriComponentsBuilder.newInstance().scheme(config.getProtocol()).host(config.getHostname()).port(config.getPort()).path(config.getPath()).build().toUri();
    }

    private RrnInquiryFixml unmarshalXML(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(RrnInquiryFixml.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        return (RrnInquiryFixml) unmarshaller.unmarshal(reader);
    }

    private RrnInquiryFixml prepareTargetRequestXml(String rrn, String correlationId, String requestId) {
        RrnInquiryFixml fixml = new RrnInquiryFixml();
        CommonHeaders header = new CommonHeaders();
        RrnInquiryBody body = new RrnInquiryBody();

        header.setRequestHeader(prepareRequestHeader(correlationId, requestId));
        body.setExecuteFinacleScriptRequest(prepareSbAcctInqRequest(rrn));

        fixml.setHeader(header);
        fixml.setBody(body);

        return fixml;
    }

    private RequestHeader prepareRequestHeader(String correlationId, String requestId) {
        RequestHeader requestHeader = new RequestHeader();
        MessageKey messageKey = new MessageKey();
        RequestMessageInfo requestMessageInfo = new RequestMessageInfo();

        messageKey.setRequestUUID(correlationId);
        messageKey.setServiceRequestId(EXECUTE_FINACLE_SCRIPT);
        messageKey.setServiceRequestVersion(SERVICE_REQUEST_VERSION);
        messageKey.setChannelId(requestId.length() >= 3 ? requestId.substring(0, 3) : requestId);
        requestHeader.setMessageKey(messageKey);

        String messageDateTime = OffsetDateTime.now(ZoneOffset.of(IST_ZONE_OFFSET)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
        requestMessageInfo.setBankId(BANK_ID);
        requestMessageInfo.setMessageDateTime(messageDateTime);
        requestHeader.setRequestMessageInfo(requestMessageInfo);

        return requestHeader;
    }

    private ExecuteFinacleScriptRequest prepareSbAcctInqRequest(String rrn) {
        ExecuteFinacleScriptRequest request = new ExecuteFinacleScriptRequest();
        ExecuteFinacleScriptInputVO inputVO = new ExecuteFinacleScriptInputVO();
        ExecuteFinacleScriptCustomData customData = new ExecuteFinacleScriptCustomData();

        inputVO.setRequestId(TAB_SBA_NONFUND_ACCT_OPN_RRN_INQ_API);
        customData.setRrn(rrn);

        request.setInputVO(inputVO);
        request.setCustomData(customData);
        return request;
    }

    private RRNInquirySourceResponse sourceResponseConverter(RrnInquiryFixml targetResponse) {
        RRNInquirySourceResponse response = new RRNInquirySourceResponse();

        if (SUCCESS.equalsIgnoreCase(targetResponse.getHeader().getResponseHeader().getHostTransaction().getStatus())) {
            RRNInquirySourceResponseBody responseBody = new RRNInquirySourceResponseBody();
            ExecuteFinacleScriptCustomData customData = targetResponse.getBody().getExecuteFinacleScriptResponse().getCustomData();

            responseBody.setTransactionCode(SUCCESSFUL_TRANSACTION_CODE);
            responseBody.setTransactionDate(customData.getTransactionDate());
            responseBody.setTransactionAmount(customData.getTransactionAmount());
            responseBody.setCustomerName(customData.getCustomerName());
            responseBody.setCustomerMobile(customData.getCustomerMobile());
            responseBody.setCustomerIfsc(customData.getCustomerIFSC());
            responseBody.setCustomerAccount(customData.getCustomerAccount());
            responseBody.setResultMsg(customData.getResultMsg());

            response.setData(responseBody);
        }else {
            response.setError(ErrorUtils.extractError(targetResponse, RrnInquiryFixml::getBody, RrnInquiryBody::getError));
        }
        return response;
    }
}
