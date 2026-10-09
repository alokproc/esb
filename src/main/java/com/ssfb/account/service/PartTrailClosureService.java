package com.ssfb.account.service;

import com.ssfb.account.config.AccountConfig;
import com.ssfb.account.dto.Error;
import com.ssfb.account.dto.partialrdclose.source.PartialrdcloseRequest;
import com.ssfb.account.dto.partialrdclose.source.PartialrdcloseResponse;
import com.ssfb.account.dto.partialrdclose.source.PartialrdcloseResponseBody;
import com.ssfb.account.dto.partialrdclose.target.*;
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
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PartTrailClosureService {

    @Autowired
    private HttpRequestUtils httpRequestUtils;

    @Autowired
    private AccountConfig config;

    private final LoggingService logging = new LoggingService();

    private final RestTemplate restTemplate;


    public PartTrailClosureService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public PartialrdcloseResponse partialrdclose(PartialrdcloseRequest request, String correlationId, String requestId) throws Exception {
        PartialrdcloseResponse response = new PartialrdcloseResponse();
        FIXML targetRequest = prepareTargetRequest(request, correlationId, requestId);
        FIXML targetResponse = new FIXML();

        try{

            logging.log(new LogEnvelope(new LogHeader("Account", "partialrdclose", "partialrdclose", "partialrdclose", "01", "OTHER", "OTHER", "INFO", "", correlationId, "", requestId, LocalDateTime.now().toString(), correlationId, "", ""),
                    new LogDetail(null, "API Request is : " + httpRequestUtils.writeXmlAsString(targetRequest))));



            targetResponse = esbAPIRestCall(restTemplate, targetRequest);

            logging.log(new LogEnvelope(new LogHeader("Account", "partialrdclose", "partialrdclose", "partialrdclose", "01", "OTHER", "OTHER", "INFO", "", correlationId, "", requestId, LocalDateTime.now().toString(), correlationId, "", ""),
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

        return  response;

    }

    private FIXML prepareTargetRequest(PartialrdcloseRequest request, String correlationId, String requestId) {
        FIXML fixml = new FIXML();
        CommonHeaders headers = new CommonHeaders();
        Body body = new Body();

        headers.setRequestHeader(prepareRequestHeader(correlationId, requestId));
        body.setExecuteFinacleScriptRequest(prepareExecuteFinacleScriptRequest(request));

        fixml.setHeaders(headers);
        fixml.setBody(body);

        return fixml;

    }

    private RequestHeader prepareRequestHeader(String correlationId, String requestId) {
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

    private ExecuteFinacleScriptRequest prepareExecuteFinacleScriptRequest(PartialrdcloseRequest request) {
        ExecuteFinacleScriptRequest executeFinacleScriptRequest = new ExecuteFinacleScriptRequest();
        ExecuteFinacleScriptInputVO executeFinacleScriptInputVO = new ExecuteFinacleScriptInputVO();
        ExecuteFinacleScriptCustomData executeFinacleScriptCustomData = new ExecuteFinacleScriptCustomData();

        String operation = request.getData().getOperation();

        Map<String, String> operationMap = Map.of(
                "PARTTRAILCLOSURE", "C_QB_TUA_PartTrailClosure_API.scr",
                "TUA_PARTCLOSURE","C_QB_TUA_PartClosure_API.scr",
                "TDPARTCLOSURE","C_QB_TDAcct_PartClosure_API.scr",
                "TDPARTTRAILCLOSURE","C_QB_TDA_PartTrailClosure_API.scr"
                );

        executeFinacleScriptInputVO.setRequestId(operationMap.get(operation.toUpperCase()));
        executeFinacleScriptRequest.setExecuteFinacleScriptInputVO(executeFinacleScriptInputVO);

        executeFinacleScriptCustomData.setAccountNumber(request.getData().getAccountNumber());
        executeFinacleScriptCustomData.setRePayAccount(request.getData().getRePaymentAccount());
        executeFinacleScriptCustomData.setClrValueDate(request.getData().getClearValueDate());
        executeFinacleScriptCustomData.setRePayMode(request.getData().getRePaymentMode());
        executeFinacleScriptCustomData.setClsrReason(request.getData().getClosureReason());
        executeFinacleScriptCustomData.setClousreamount(request.getData().getClousreAmount());

        executeFinacleScriptRequest.setExecuteFinacleScriptCustomData(executeFinacleScriptCustomData);

        return executeFinacleScriptRequest;
    }

    private PartialrdcloseResponse prepareSourceResponse(FIXML targetResponse){
        PartialrdcloseResponse response = new PartialrdcloseResponse();
        PartialrdcloseResponseBody responseBody = new PartialrdcloseResponseBody();
        Error error = new Error();

        if (targetResponse.getHeaders().getResponseHeader().getHostTransaction().getStatus().equalsIgnoreCase("SUCCESS")){
            responseBody.setTransactionCode("00");
            responseBody.setDepositAmount(targetResponse.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getDepositAmt());
            responseBody.setEffectiveInterestPercent(targetResponse.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getEffIntPcnt());
            responseBody.setNormalInterestPercent(targetResponse.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getNormalIntAmt());
            responseBody.setNetInterestPaid(targetResponse.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getNetIntrestPaid());
            responseBody.setNormalInterestAmount(targetResponse.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getNormalIntAmt());
            responseBody.setPenaltyAmount(targetResponse.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getPenaltyAmount());
            responseBody.setRepaymentAccountId(targetResponse.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getRepaymentAcctId());
            responseBody.setFdClosureAmount(targetResponse.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getFdClosureAmount());
            responseBody.setTransactionId(targetResponse.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getTranId());
            responseBody.setTransactionDate(targetResponse.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getTranDate());

            responseBody.setMessage(targetResponse.getBody().getExecuteFinacleScriptResponse().getExecuteFinacleScriptCustomData().getMSG());

            response.setData(responseBody);
        }         else {
            error.setCode(targetResponse.getBody().getError().getFiBusinessException().getErrorDetail().getErrorCode());
            error.setDescription(targetResponse.getBody().getError().getFiBusinessException().getErrorDetail().getErrorDesc());
            response.setError(error);
        }

        return response;

    }

    private FIXML unmarshalXML(String xml) throws JAXBException{
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

