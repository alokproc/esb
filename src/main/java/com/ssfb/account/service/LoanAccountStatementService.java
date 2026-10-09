package com.ssfb.account.service;

import com.ssfb.account.config.AccountConfig;
import com.ssfb.account.dto.loanstatement.source.LoanAccountStatementRequest;
import com.ssfb.account.dto.loanstatement.source.LoanAccountStatementResponse;
import com.ssfb.account.dto.loanstatement.source.LoanAccountStatementResponseBody;
import com.ssfb.account.dto.loanstatement.target.*;
import com.ssfb.commonmodule.dto.Error;
import com.ssfb.commonmodule.dto.fixml.* ;
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
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.StringReader;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class LoanAccountStatementService {

    private final RestTemplate restTemplate;

    private final LoggingService logging = new LoggingService();

    @Autowired
    private AccountConfig config;

    @Autowired
    private HttpRequestUtils requestUtils;

    @Autowired
    public LoanAccountStatementService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public  LoanAccountStatementResponse fetchLoanAccountStatement(LoanAccountStatementRequest request,String correlationId,String requestId){
        LoanAccountStatementResponse response=new LoanAccountStatementResponse();
        FIXML targetResponse=new FIXML();
        FIXML targetRequest=prepareTargetRequest(request,correlationId,requestId);
        try {
            logging.log(new LogEnvelope(new LogHeader("Account","Loan Account Statement","Loan Account Statement","Loan Account Statement","01","OTHER","IN","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null, "API Request is: "+ requestUtils.writeXmlAsString(targetRequest))));

            targetResponse=esbRESTCall(restTemplate,targetRequest,correlationId,requestId);
            logging.log(new LogEnvelope(new LogHeader("Account","Loan Account Statement","Loan Account Statement","Loan Account Statement","01","OTHER","OUT","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null, "API Response is: "+ requestUtils.writeXmlAsString(targetResponse)))
            );
            response= prepareSourceResponse(targetResponse);
        } catch (Exception e) {

            try {
                // Extract the <FIXML> block using regex
                Pattern pattern = Pattern.compile("<FIXML[\\s\\S]*?</FIXML>");
                Matcher matcher = pattern.matcher( e.getMessage());

                if (!matcher.find()) {
                    throw new RuntimeException("FIXML block not found in error message");
                }

                String xmlString = matcher.group(0)
                        .replace("<EOL>", "");

                targetResponse=unmarshalXML(xmlString);
            } catch (JAXBException ex) {
                throw new RuntimeException(ex);
            }
            if(targetResponse.getBody().getError().getFiSystemException()!=null)
                response.setError(new Error(targetResponse.getBody().getError().getFiSystemException().getErrorDetail().getErrorCode(),targetResponse.getBody().getError().getFiSystemException().getErrorDetail().getErrorDesc()));
            else
                response.setError(new Error(targetResponse.getBody().getError().getFiBusinessException().getErrorDetail().getErrorCode(),targetResponse.getBody().getError().getFiBusinessException().getErrorDetail().getErrorDesc()));
            try {
                logging.log(new LogEnvelope(new LogHeader("Account","Loan Account Statement","Loan Account Statement","Loan Account Statement","01","OTHER","OUT","ERROR","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                        new LogDetail(null, "API Response is: "+requestUtils.writeXmlAsString(targetResponse))));
            } catch (Exception e1) {
                throw new RuntimeException(e1);
            }
        }



        return response;

    }

    //Target Request Convertor
    private FIXML prepareTargetRequest(LoanAccountStatementRequest request, String correlationId, String requestId){
        FIXML fixml = new FIXML();
        CommonHeaders header = new CommonHeaders();
        Body body = new Body();

        header.setRequestHeader(prepareRequestHeader(correlationId, requestId));
        body.setExecuteFinacleScriptRequest(prepareExecuteFinacleScriptRequest(request));

        fixml.setHeader(header);
        fixml.setBody(body);

        return fixml;
    }

    private ExecuteFinacleScriptRequest prepareExecuteFinacleScriptRequest(LoanAccountStatementRequest request) {
        ExecuteFinacleScriptRequest executeFinacleScriptRequest = new ExecuteFinacleScriptRequest();
        ExecuteFinacleScriptInputVO executeFinacleScriptInputVO = new ExecuteFinacleScriptInputVO();
        ExecuteFinacleScriptCustomData executeFinacleScriptCustomData = new ExecuteFinacleScriptCustomData();

        BeanUtils.copyProperties(request.getData(), executeFinacleScriptCustomData);
        //executeFinacleScriptCustomData.setAccountId(request.getData().getAccountId());
        executeFinacleScriptRequest.setExecuteFinacleScriptCustomData(executeFinacleScriptCustomData);
        executeFinacleScriptRequest.setExecuteFinacleScriptInputVO(executeFinacleScriptInputVO);

        return executeFinacleScriptRequest;
    }

    private RequestHeader prepareRequestHeader(String correlationID, String requestID) {
        RequestHeader requestHeader = new RequestHeader();
        MessageKey messageKey = new MessageKey();
        RequestMessageInfo requestMessageInfo = new RequestMessageInfo();

        messageKey.setRequestUUID(correlationID);
        messageKey.setServiceRequestId("executeFinacleScript");
        messageKey.setChannelId(requestID.substring(0, 3));
        requestHeader.setMessageKey(messageKey);

        requestMessageInfo.setBankId("01");
        requestMessageInfo.setMessageDateTime(currentDateTime());
        requestHeader.setRequestMessageInfo(requestMessageInfo);

        return requestHeader;
    }

    private String currentDateTime() {
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return currentDateTime.format(formatter);
    }



    private URI esbURIBuilder(){
        return UriComponentsBuilder.newInstance().scheme(config.getProtocol()).host(config.getHostname()).port(config.getPort()).path(config.getPath()).build().toUri();
    }

    private FIXML unmarshalXML(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FIXML.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        return (FIXML) unmarshaller.unmarshal(reader);
    }


    //Financle Rest Call
    public FIXML esbRESTCall(RestTemplate restTemplate, FIXML targetRequest,String correlationId,String requestId) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);

        ResponseEntity<String> response = restTemplate.exchange(esbURIBuilder(), HttpMethod.POST, new HttpEntity<>(targetRequest, headers), String.class);

        // unmarshalXML(response.getBody());
        // return response.getBody();
        return unmarshalXML(response.getBody());
    }
    /* public FIXML esbRESTCall(RestTemplate restTemplate, FIXML targetRequest,String correlationId,String requestId) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);

        logging.log(new LogEnvelope(new LogHeader("Account","Loan Account Statement","Loan Account Statement","Loan Account Statement","01","OTHER","IN","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                new LogDetail(null,  "API Request is " +requestUtils.writeValueAsString(targetRequest))));
        ResponseEntity<String> response = restTemplate.exchange(esbURIBuilder(), HttpMethod.POST, new HttpEntity<>(targetRequest, headers), String.class);
        logging.log(new LogEnvelope(new LogHeader("Account","Loan Account Statement","Loan Account Statement","Account Inquiry","01","OTHER","OUT","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                new LogDetail(null, "API Response is: "+ requestUtils.writeValueAsString(response.getBody()))));

        return unmarshalXML(response.getBody());
    }*/


    // Source Response Convertor
    private LoanAccountStatementResponse prepareSourceResponse(FIXML fixml) {
        LoanAccountStatementResponse response = new LoanAccountStatementResponse();
        LoanAccountStatementResponseBody responseBody = new LoanAccountStatementResponseBody();
        Error error=new Error();

        if(fixml.getHeader().getResponseHeader().getHostTransaction().getStatus().equalsIgnoreCase("SUCCESS")){
            if(fixml.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getErrorDesc()!=null){
                error.setCode("01");
                error.setDescription(fixml.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getErrorDesc());
                response.setError(error);
            } else {
                responseBody.setTransactionCode("00");
                responseBody.setBase64String(fixml.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getBase64String());
                response.setData(responseBody);
            }
        }

        return response;
    }


    private static <T, B> Error extractError(T targetResponse, Function<T, B> bodyExtractor, Function<B, CommonError> errorExtractor) {
        CommonError error = errorExtractor.apply(bodyExtractor.apply(targetResponse));
        if (error != null) {
            if (error.getFiBusinessException() != null && error.getFiBusinessException().getErrorDetail() != null) {
                return new Error(error.getFiBusinessException().getErrorDetail().getErrorCode(), error.getFiBusinessException().getErrorDetail().getErrorDesc());
            } else if (error.getFiSystemException() != null && error.getFiSystemException().getErrorDetail() != null) {
                return new Error(error.getFiSystemException().getErrorDetail().getErrorCode(),error.getFiSystemException().getErrorDetail().getErrorDesc());
            }
        }
        return new Error(null, null);
    }


}
