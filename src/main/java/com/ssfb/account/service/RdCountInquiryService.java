package com.ssfb.account.service;

import com.ssfb.account.config.AccountConfig;
import com.ssfb.account.dto.rdcountinquirypercustomer.source.RdCountInquirySourceRequest;
import com.ssfb.account.dto.rdcountinquirypercustomer.source.RdCountInquirySourceResponse;
import com.ssfb.account.dto.rdcountinquirypercustomer.source.RdCountInquirySourceResponseBody;
import com.ssfb.account.dto.rdcountinquirypercustomer.target.*;
import com.ssfb.commonmodule.utils.HttpRequestUtils;
import com.ssfb.logging.model.ErrorDetail;
import com.ssfb.logging.model.*;
import com.ssfb.logging.service.LoggingService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.StringReader;
import java.lang.Error;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static com.ssfb.account.dto.Constants.BANK_ID;
import static com.ssfb.account.dto.Constants.SERVICE_REQUEST_VERSION;

@Service
public class RdCountInquiryService {

    private final RestTemplate restTemplatet;

    public RdCountInquiryService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplatet=restTemplateBuilder.build();
    }

    @Autowired
    private AccountConfig accountConfig;

    @Autowired
    private HttpRequestUtils requestUtils;

    private URI rdCountInquiryURIBuilder(){
        return UriComponentsBuilder.newInstance().scheme(accountConfig.getProtocol()).host(accountConfig.getHostname()).port(accountConfig.getPort()).path(accountConfig.getPath()).build().toUri();
    }

    private LoggingService logging = new LoggingService();

    public FIXML callFinacleAPI(FIXML request, String correlationId, String requestId) throws Exception{
        ResponseEntity<String> response = null;
        FIXML targetResponse =new FIXML();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        try {
            logging.log(new LogEnvelope(new LogHeader("AccountManagement", "RdCountInquiry", "RdCountInquiry", "RdCountInquiry", "01", "OTHER", "IN", "INFO", "", correlationId, "", requestId, LocalDateTime.now().toString(), correlationId, "", ""),
                    new LogDetail(null, "API Request is: " + requestUtils.writeValueAsString(request))));

            response=restTemplatet.exchange(rdCountInquiryURIBuilder(), HttpMethod.POST, new HttpEntity<>(request, headers), String.class);

            JAXBContext jaxbContext = JAXBContext.newInstance(FIXML.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(response.getBody());
            targetResponse =(FIXML) unmarshaller.unmarshal(reader);

            logging.log(new LogEnvelope(new LogHeader("AccountManagement","RdCountInquiry","RdCountInquiry","RdCountInquiry","01","OTHER","OUT","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null, "API Response is: "+ requestUtils.writeValueAsString(response))));

        }catch (Exception e){
            e.printStackTrace();
        }
        return  targetResponse;
    }
    private String currentDateTime() {
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return currentDateTime.format(formatter);
    }
    public FIXML prepareTargetRequest(RdCountInquirySourceRequest request, String correlationId, String requestId){
        FIXML targetRequest=new FIXML();
        Header header=new Header();
        Body body=new Body();
        RequestHeader requestHeader=new RequestHeader();
        MessageKey messageKey=new MessageKey();
        RequestMessageInfo requestMessageInfo=new RequestMessageInfo();

        messageKey.setRequestUUID(correlationId);
        messageKey.setServiceRequestId("executeFinacleScript");
        messageKey.setServiceRequestVersion(SERVICE_REQUEST_VERSION);
        messageKey.setChannelId(requestId.substring(0,3));
        requestHeader.setMessageKey(messageKey);

        requestMessageInfo.setBankId(BANK_ID);
        requestMessageInfo.setMessageDateTime(currentDateTime()+"+05:30");
        requestHeader.setRequestMessageInfo(requestMessageInfo);
        header.setRequestHeader(requestHeader);

        ExecuteFinacleScriptRequest executeFinacleScriptRequest=new ExecuteFinacleScriptRequest();
        ExecuteFinacleScriptInputVO executeFinacleScriptInputVO=new ExecuteFinacleScriptInputVO();
        ExecuteFinacleScriptCustomData executeFinacleScriptCustomData=new ExecuteFinacleScriptCustomData();

        executeFinacleScriptCustomData.setCustomerId(request.getData().getCustomerId());
        executeFinacleScriptRequest.setExecuteFinacleScriptCustomData(executeFinacleScriptCustomData);
        executeFinacleScriptRequest.setExecuteFinacleScriptInputVO(executeFinacleScriptInputVO);
        body.setExecuteFinacleScriptRequest(executeFinacleScriptRequest);
        targetRequest.setBody(body);
        targetRequest.setHeader(header);
        return targetRequest;
    }
    public RdCountInquirySourceResponse sourceResponseConverter(FIXML targetResponse){
        RdCountInquirySourceResponse sourceResponse=new RdCountInquirySourceResponse();
        RdCountInquirySourceResponseBody responseBody=new RdCountInquirySourceResponseBody();
        Error error=new Error();
        System.out.println("targetResponse"+targetResponse);
        if(targetResponse.getHeader().getResponseHeader().getHostTransaction().getStatus().equalsIgnoreCase("SUCCESS")){

            responseBody.setTransactionCode("00");
            responseBody.setStatus(targetResponse.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getMessage());
            responseBody.setResponseMessage(targetResponse.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getStatus());

        }else {
            responseBody.setTransactionCode("00");
            responseBody.setStatus(targetResponse.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getMessage());
            responseBody.setResponseMessage(targetResponse.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getStatus());
        }
        sourceResponse.setData(responseBody);
        return sourceResponse;
    }

    public RdCountInquirySourceResponse rdCountInquiryFunction(RdCountInquirySourceRequest rdCountInquirySourceRequest,String correlationId,String requestId) throws Exception {
        RdCountInquirySourceResponse sourceResponse = new RdCountInquirySourceResponse();
        FIXML targetRequest = new FIXML();
        FIXML targetResponse = new FIXML();
        try {

            targetRequest = prepareTargetRequest(rdCountInquirySourceRequest, correlationId, requestId);
            targetResponse = callFinacleAPI(targetRequest, correlationId, requestId);
            sourceResponse = sourceResponseConverter(targetResponse);
            logging.log(new LogEnvelope(new LogHeader("AccountManagement", "RdCountInquiry", "RdCountInquiry", "RdCountInquiry", "01", "END", "OUT", "INFO", "", correlationId, "", requestId, LocalDateTime.now().toString(), correlationId, "", ""),
                    new LogDetail(null, "API Response is: " + requestUtils.writeValueAsString(sourceResponse))));

        } catch (Exception e) {
            e.printStackTrace();
            logging.log(new LogEnvelope(new LogHeader("AccountManagement", "RdCountInquiry", "RdCountInquiry", "RdCountInquiry", "01", "OTHER", "OUT", "ERROR", "", correlationId, "", requestId, LocalDateTime.now().toString(), correlationId, "", ""),
                    new LogDetail(new ErrorDetail("01", "", "", new ErrorDescription(e.getLocalizedMessage(), "01", Arrays.toString(e.getStackTrace())), new ProcessContext("RdCountInquiry", "Test")), "API Response is: " + requestUtils.writeValueAsString(sourceResponse))));

        }
        return sourceResponse;
    }
}
