package com.ssfb.account.service;

import com.ssfb.account.config.FrmConfig;
import com.ssfb.account.dto.accountbalance.target.balanceinq.*;
import com.ssfb.account.util.URIBuilderUtil;
import com.ssfb.commonmodule.utils.DateFormatter;
import com.ssfb.commonmodule.utils.GenerateEpoch;
import com.ssfb.commonmodule.utils.HttpRequestUtils;
import com.ssfb.commonmodule.utils.IdUtils;
import com.ssfb.logging.model.*;
import com.ssfb.logging.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Arrays;

import static com.ssfb.account.dto.Constants.*;

@Service
public class BalanceInquiryService {
    private final RestTemplate restTemplate;

    @Autowired
    private URIBuilderUtil uriBuilderUtil;

    @Autowired
    private HttpRequestUtils requestUtils;

    @Autowired
    private FrmConfig frmConfig;

    private final LoggingService logging = new LoggingService();

    @Autowired
    public BalanceInquiryService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public void balanceInquiry(BalInqReq balInqReq, String correlationId, String requestId) throws Exception {
        String eventId = IdUtils.generateEventId();
        long epoch = GenerateEpoch.DateTimeToEpoch(DateFormatter.currentDatetimeISO8601WithoutTSSS());

        BalInqMsgBody balInqMsgBody = prepareBalanceInquiryMessageBody(balInqReq, eventId);
        BalInqFRMReq balInqFRMReq = prepareBalInqFRMReq(balInqMsgBody, eventId, balInqReq, epoch);

        sendBalanceTransactionEnquiryToClarify(balInqFRMReq, correlationId, requestId);
    }

    private void sendBalanceTransactionEnquiryToClarify(BalInqFRMReq balInqFRMReq, String correlationId, String requestId) throws Exception {
        ClarifyRequest clarifyRequest = prepareClarifyRequest(balInqFRMReq);
        ClarifiveRequest clarifiveRequest = prepareClarifiveRequest(clarifyRequest, balInqFRMReq);

        try {
            String clarifiveFRMTargetResponse;
            int index = 1;
            while (index <= 3) {
                clarifiveFRMTargetResponse = clarifiveFRMAPI(clarifiveRequest, correlationId, requestId);
                if (clarifiveFRMTargetResponse.equalsIgnoreCase(TRUE)) {
                    break;
                }
                index++;
                Thread.sleep(60000);
            }
        } catch (Exception e) {
            logging.log(new LogEnvelope(new LogHeader("Account","BalInq","BalInq","BalInq","01","OTHER","OUT","ERROR","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(new ErrorDetail("01","","",new ErrorDescription(e.getLocalizedMessage(),"01", Arrays.toString(e.getStackTrace())),new ProcessContext("sendBalanceTransactionEnquiryToClarify","Test")), null)));
        }
    }

    private String clarifiveFRMAPI(ClarifiveRequest clarifiveRequest, String correlationId, String requestId) throws Exception {
        ClarifiveFRMTarget clarifiveFRMTarget = new ClarifiveFRMTarget();
        clarifiveFRMTarget.setAsciiContent(clarifiveRequest.getPayload());

        logging.log(new LogEnvelope(new LogHeader("Account","BalInq","BalInq","BalInq","01","OTHER","IN","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                new LogDetail(null,  "API Request is: "+ requestUtils.writeValueAsString(clarifiveFRMTarget))));
        ResponseEntity<String> clarifiveFRMTargetResponse = restTemplate.exchange(clarifiveFRMURIbuilder(), HttpMethod.POST, new HttpEntity<>(clarifiveFRMTarget), String.class);
        logging.log(new LogEnvelope(new LogHeader("Account","BalInq","BalInq","BalInq","01","OTHER","OUT","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                new LogDetail(null, "API Response is: "+ requestUtils.writeValueAsString(clarifiveFRMTargetResponse))));
        return clarifiveFRMTargetResponse.getBody();
    }

    private URI clarifiveFRMURIbuilder() {
        return UriComponentsBuilder.newInstance().scheme(frmConfig.getProtocol()).host(frmConfig.getHostname())
                .port(frmConfig.getPort()).path(frmConfig.getPath()).queryParam("q", CLARIFIVE_FRM_HOST).build().toUri();
    }

    private ClarifiveRequest prepareClarifiveRequest(ClarifyRequest clarifyRequest, BalInqFRMReq balInqFRMReq) throws Exception {
        ClarifiveRequest clarifiveRequest = new ClarifiveRequest();
        clarifiveRequest.setPayload(requestUtils.writeValueAsString(clarifyRequest));
        clarifiveRequest.setEventId(balInqFRMReq.getEventId());
        clarifiveRequest.setEventTs(balInqFRMReq.getEventTimestamp());
        clarifiveRequest.setEntityId(balInqFRMReq.getCustId());
        return clarifiveRequest;
    }

    private BalInqFRMReq prepareBalInqFRMReq(BalInqMsgBody balInqMsgBody, String eventId, BalInqReq balInqReq, long epoch) throws Exception {
        BalInqFRMReq balInqFRMReq = new BalInqFRMReq();
        balInqFRMReq.setOperation(BALANCE_ENQUIRY);
        balInqFRMReq.setMsgBody(requestUtils.writeValueAsString(balInqMsgBody));
        balInqFRMReq.setEventId(eventId);
        if(balInqReq.getCustId() != null & !balInqReq.getCustId().trim().isEmpty()){
            balInqFRMReq.setCustId(balInqReq.getCustId());
        }
        balInqFRMReq.setEventTimestamp(epoch);
        balInqFRMReq.setEventType(NFT);
        balInqFRMReq.setEventSubType(BALANCE_ENQUIRY.toLowerCase());
        balInqFRMReq.setEventName(NFT_BALANCE_ENQUIRY);
        balInqFRMReq.setSource(DB);
        return balInqFRMReq;
    }

    private BalInqMsgBody prepareBalanceInquiryMessageBody(BalInqReq balInqReq, String eventId) {
        BalInqMsgBody balInqMsgBody = new BalInqMsgBody();
        balInqMsgBody.setHostId("F");
        balInqMsgBody.setSystemTime(balInqReq.getSysTime());
        balInqMsgBody.setEventId(eventId);
        balInqMsgBody.setAccountId(balInqReq.getAccountId());
        balInqMsgBody.setAvailableBalance(balInqReq.getAvlBal());
        balInqMsgBody.setBranchId(balInqReq.getBranchId());
        balInqMsgBody.setCardNumber(balInqReq.getCardNo());
        balInqMsgBody.setLastTransactionDate(balInqReq.getLastTxnDate());
        balInqMsgBody.setChannel(balInqReq.getChannel());
        balInqMsgBody.setUserId(balInqReq.getUserId());
        balInqMsgBody.setCustomerId(balInqReq.getCustId());
        balInqMsgBody.setInsertionDate(balInqReq.getInsertionDate());
        balInqMsgBody.setAdditionalEntity1(balInqReq.getAddEntity1());
        balInqMsgBody.setAdditionalEntity2(balInqReq.getAddEntity2());
        balInqMsgBody.setAdditionalEntity3(balInqReq.getAddEntity3());
        balInqMsgBody.setAdditionalEntity4(balInqReq.getAddEntity4());
        balInqMsgBody.setAdditionalEntity5(balInqReq.getAddEntity5());
        return balInqMsgBody;
    }

    private ClarifyRequest prepareClarifyRequest(BalInqFRMReq balInqFRMReq) {
        ClarifyRequest clarifyRequest = new ClarifyRequest();
        clarifyRequest.setEventtype(balInqFRMReq.getEventType());
        clarifyRequest.setEventsubtype(balInqFRMReq.getEventSubType());
        clarifyRequest.setEventname(balInqFRMReq.getEventName());
        clarifyRequest.setEventId(balInqFRMReq.getEventId());
        clarifyRequest.setEventts(balInqFRMReq.getEventTimestamp());
        clarifyRequest.setSource(DateFormatter.currentDatetimeISO8601WithoutT());
        clarifyRequest.setMsgBody(balInqFRMReq.getMsgBody().replaceAll("\"", "'"));
        return clarifyRequest;
    }
}
