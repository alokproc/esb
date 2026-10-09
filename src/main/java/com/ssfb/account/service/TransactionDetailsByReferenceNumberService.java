package com.ssfb.account.service;

import com.ssfb.account.config.AccountConfig;
import com.ssfb.account.dto.Error;
import com.ssfb.account.dto.transactionDetailsByRefNumber.source.TransactionDetails;
import com.ssfb.account.dto.transactionDetailsByRefNumber.source.TransactionDetailsByReferenceNumberRequest;
import com.ssfb.account.dto.transactionDetailsByRefNumber.source.TransactionDetailsByReferenceNumberResponse;
import com.ssfb.account.dto.transactionDetailsByRefNumber.source.TransactionDetailsByReferenceNumberResponseBody;
import com.ssfb.account.dto.transactionDetailsByRefNumber.target.*;
import com.ssfb.commonmodule.dto.fixml.CommonHeaders;
import com.ssfb.commonmodule.dto.fixml.MessageKey;
import com.ssfb.commonmodule.dto.fixml.RequestHeader;
import com.ssfb.commonmodule.dto.fixml.RequestMessageInfo;
import com.ssfb.commonmodule.utils.HttpRequestUtils;
import com.ssfb.logging.model.LogDetail;
import com.ssfb.logging.model.LogEnvelope;
import com.ssfb.logging.model.LogHeader;
import com.ssfb.logging.service.LoggingService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.StringReader;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TransactionDetailsByReferenceNumberService {

    @Autowired
    private HttpRequestUtils httpRequestUtils;

    @Autowired
    private AccountConfig config;

    private final LoggingService logging = new LoggingService();

    private final RestTemplate restTemplate;


    public TransactionDetailsByReferenceNumberService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public TransactionDetailsByReferenceNumberResponse transactionDetailsByReferenceNumber(TransactionDetailsByReferenceNumberRequest request,  String correlationId, String requestId) throws Exception{
        TransactionDetailsByReferenceNumberResponse response = new TransactionDetailsByReferenceNumberResponse();
        FIXML targetRequest = prepareTargetRequest(request,correlationId,requestId);
        FIXML targetResponse = new FIXML();

        try{
            logging.log(new LogEnvelope(new LogHeader("Account", "TransactionDetailsByReferenceNumber", "TransactionDetailsByReferenceNumber", "TransactionDetailsByReferenceNumber", "01", "OTHER", "OTHER", "INFO", "", correlationId, "", requestId, LocalDateTime.now().toString(), correlationId, "", ""),
                    new LogDetail(null, "API Request is : " + httpRequestUtils.writeXmlAsString(targetRequest))));

            targetResponse = esbAPIRestCall(restTemplate, targetRequest);

            logging.log(new LogEnvelope(new LogHeader("Account", "TransactionDetailsByReferenceNumber", "TransactionDetailsByReferenceNumber", "TransactionDetailsByReferenceNumber", "01", "OTHER", "OTHER", "INFO", "", correlationId, "", requestId, LocalDateTime.now().toString(), correlationId, "", ""),
                    new LogDetail(null, "API Response is : " + httpRequestUtils.writeXmlAsString(targetResponse))));

            response = prepareSourceResponse(targetResponse);


        } catch (Exception e) {
            try {
                // Extract the <FIXML> block using regex
                Pattern pattern = Pattern.compile("<FIXML[\\s\\S]*?</FIXML>");
                Matcher matcher = pattern.matcher(e.getMessage());

                if (!matcher.find()) {
                    throw new RuntimeException("FIXML block not found in error message");
                }

                String xmlString = matcher.group(0)
                        .replace("<EOL>", "");

                targetResponse = unmarshalXML(xmlString);
            } catch (JAXBException ex) {
                throw new RuntimeException(ex);
            }
        }

        return response;
    }

    private FIXML prepareTargetRequest(TransactionDetailsByReferenceNumberRequest request,  String correlationId, String requestId){
        FIXML fixml = new FIXML();
        CommonHeaders headers = new CommonHeaders();
        Body body = new Body();

        headers.setRequestHeader(prepareRequestHeader(correlationId,requestId));
        body.setExecuteFinacleScriptRequest(prepareExecuteFinacleScriptRequest(request));

        fixml.setHeaders(headers);
        fixml.setBody(body);

        return fixml;
    }

    private RequestHeader prepareRequestHeader( String correlationId, String requestId){
        RequestHeader requestHeader = new RequestHeader();
        MessageKey messageKey = new MessageKey();
        RequestMessageInfo requestMessageInfo = new RequestMessageInfo();

        messageKey.setRequestUUID(correlationId);
        messageKey.setServiceRequestId("executeFinacleScript");
        messageKey.setServiceRequestVersion("10.2");
        if (requestId != null && requestId.length() >= 3) {
            messageKey.setChannelId(requestId.substring(0, 3));
        } else {
            messageKey.setChannelId(requestId);
        }
        requestHeader.setMessageKey(messageKey);

        requestMessageInfo.setBankId("01");
        requestMessageInfo.setMessageDateTime(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));

        requestHeader.setRequestMessageInfo(requestMessageInfo);

        return requestHeader;
    }

    private ExecuteFinacleScriptRequest prepareExecuteFinacleScriptRequest(TransactionDetailsByReferenceNumberRequest request){
        ExecuteFinacleScriptRequest executeFinacleScriptRequest = new ExecuteFinacleScriptRequest();
        ExecuteFinacleScriptCustomData customData = new ExecuteFinacleScriptCustomData();
        ExecuteFinacleScriptInputVO inputVO = new ExecuteFinacleScriptInputVO();

        inputVO.setRequestId("C_QB_REF_TRANSACTION_DET.scr");
        executeFinacleScriptRequest.setExecuteFinacleScriptInputVO(inputVO);

        customData.setReferenceNumber(request.getData().getReferenceNumber());

        executeFinacleScriptRequest.setExecuteFinacleScriptCustomData(customData);

        return executeFinacleScriptRequest;


    }

    private TransactionDetailsByReferenceNumberResponse prepareSourceResponse(FIXML fixml){
        TransactionDetailsByReferenceNumberResponse response = new TransactionDetailsByReferenceNumberResponse();
        TransactionDetailsByReferenceNumberResponseBody responseBody = new TransactionDetailsByReferenceNumberResponseBody();
        Error error = new Error();

        if (fixml.getHeaders().getResponseHeader().getHostTransaction().getStatus().equalsIgnoreCase("SUCCESS") && (fixml .getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getTransactionDetails()!=null
                && !fixml .getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getTransactionDetails().isEmpty() )) {
            responseBody.setTransactionCode("00");
            List<com.ssfb.account.dto.transactionDetailsByRefNumber.target.TransactionDetails> transactionDetailsTargetresponseList = fixml.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getTransactionDetails();

            List<TransactionDetails> transactionDetailsList = transactionDetailsTargetresponseList.stream().map(target -> {
                TransactionDetails source = new TransactionDetails();
                BeanUtils.copyProperties(target, source);

                return source;

            }) .toList();
            responseBody.setTransactionDetails(transactionDetailsList);
            response.setData(responseBody);

        } else  {
            error.setCode(fixml.getBody().getError().getFiBusinessException().getErrorDetail().getErrorCode());
            error.setDescription(fixml.getBody().getError().getFiBusinessException().getErrorDetail().getErrorDesc());
            response.setError(error);
        }
        return response;

    }

    private FIXML unmarshalXML(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FIXML.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        return(FIXML) unmarshaller.unmarshal(reader);
    }

    private FIXML esbAPIRestCall(RestTemplate restTemplate, FIXML targetRequest) throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);

        ResponseEntity<String> response = restTemplate.exchange(URIBuilder(), HttpMethod.POST,  new HttpEntity<>(targetRequest, headers), String.class);

        return unmarshalXML(response.getBody());

    }
    private URI URIBuilder(){
        return UriComponentsBuilder.newInstance().scheme(config.getProtocol()).host(config.getHostname()).port(config.getPort()).path(config.getPath()).build().toUri();
    }
}
