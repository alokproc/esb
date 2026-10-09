package com.ssfb.account.service;

import com.ssfb.account.dto.Error;
import com.ssfb.account.dto.accountbalance.common.AcctId;
import com.ssfb.account.dto.accountbalance.common.AcctInqCustomData;
import com.ssfb.account.dto.accountbalance.target.balanceinq.BalInqReq;
import com.ssfb.account.dto.accountbalance.target.caacct.*;
import com.ssfb.account.dto.accountbalance.source.AccountBalanceSourceResponse;
import com.ssfb.account.dto.accountbalance.source.AccountBalanceSourceResponseBody;
import com.ssfb.account.dto.accountbalance.source.Balance;
import com.ssfb.account.dto.accountbalance.source.Product;
import com.ssfb.account.util.URIBuilderUtil;
import com.ssfb.commonmodule.dto.fixml.*;
import com.ssfb.commonmodule.utils.DateFormatter;
import com.ssfb.commonmodule.utils.HttpRequestUtils;
import com.ssfb.logging.model.*;
import com.ssfb.logging.service.LoggingService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.*;

import static com.ssfb.account.dto.Constants.*;

@Service
public class CurrentAcctInqService {
    private final RestTemplate restTemplate;

    @Autowired
    private HttpRequestUtils requestUtils;

    @Autowired
    private URIBuilderUtil uriBuilderUtil;

    @Autowired
    private BalanceInquiryService balanceInquiryService;

    private final LoggingService logging = new LoggingService();

    @Autowired
    public CurrentAcctInqService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public AccountBalanceSourceResponse currentAccountInquiry(String accountId, String token, String version, String correlationId, String requestId) throws Exception {
        AccountBalanceSourceResponse response = new AccountBalanceSourceResponse();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);

        try {
            FIXML fixml = prepareXMLRequestBody(accountId, correlationId, requestId);

            logging.log(new LogEnvelope(new LogHeader("Account","CAAcctInq","CAAcctInq","CAAcctInq","01","OTHER","IN","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null,  "API Request is: "+ requestUtils.writeValueAsString(fixml))));
            ResponseEntity<String> responseEntity = restTemplate.exchange(uriBuilderUtil.accountURI(), HttpMethod.POST, new HttpEntity<>(fixml, headers), String.class);

            logging.log(new LogEnvelope(new LogHeader("Account","CAAcctInq","CAAcctInq","CAAcctInq","01","OTHER","OUT","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null, "API Response is: "+ requestUtils.writeValueAsString(responseEntity.getBody()))));

            FIXML targetResponse = unmarshalXML(responseEntity.getBody());

            if (M2P.equalsIgnoreCase(requestId) && targetResponse.getBody().getCaAcctInqResponse() != null) {
                BalInqReq balInqReq = prepareBalanceInquiryRequest(targetResponse, accountId, requestId);
                balanceInquiryService.balanceInquiry(balInqReq, correlationId, requestId);
            }
            response = sourceResponseConverter(targetResponse, requestId);
            logging.log(new LogEnvelope(new LogHeader("Account","CAAcctInq","CAAcctInq","CAAcctInq","01","END","OUT","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null, "API Response is: "+ requestUtils.writeValueAsString(response))));
        } catch (Exception e) {
            response.setError(new Error(EXCEPTION_ERR_CODE, EXCEPTION_ERR_DESC_GEN));
            logging.log(new LogEnvelope(new LogHeader("Account","CAAcctInq","CAAcctInq","CAAcctInq","01","OTHER","OUT","ERROR","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(new ErrorDetail("01","","",new ErrorDescription(e.getLocalizedMessage(),"01", Arrays.toString(e.getStackTrace())),new ProcessContext("currentAccountInquiry","Test")), "API Response is: "+ requestUtils.writeValueAsString(response))));
        }
        return response;
    }

    private FIXML unmarshalXML(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FIXML.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        return (FIXML) unmarshaller.unmarshal(reader);
    }

    private FIXML prepareXMLRequestBody(String accountId, String correlationId, String requestId) {
        FIXML fixml = new FIXML();
        CommonHeaders header = new CommonHeaders();
        Body body = new Body();

        header.setRequestHeader(prepareRequestHeader(correlationId, requestId));
        body.setCaAcctInqRequest(prepareCaAcctInqRequest(accountId));

        fixml.setHeader(header);
        fixml.setBody(body);

        return fixml;
    }

    private RequestHeader prepareRequestHeader(String correlationId, String requestId) {
        RequestHeader requestHeader = new RequestHeader();
        MessageKey messageKey = new MessageKey();
        RequestMessageInfo requestMessageInfo = new RequestMessageInfo();

        messageKey.setRequestUUID(correlationId);
        messageKey.setServiceRequestId(CA_ACCT_INQ);
        messageKey.setServiceRequestVersion(SERVICE_REQUEST_VERSION);
        messageKey.setChannelId(requestId.substring(0, 3));
        requestHeader.setMessageKey(messageKey);

        requestMessageInfo.setBankId(BANK_ID);
        requestMessageInfo.setMessageDateTime(DateFormatter.currentDateTimeZ());
        requestHeader.setRequestMessageInfo(requestMessageInfo);

        return requestHeader;
    }

    private CAAcctInqRequest prepareCaAcctInqRequest(String accountId) {
        CAAcctInqRequest caAcctInqRequest = new CAAcctInqRequest();
        CAAcctInqRq caAcctInqRq = new CAAcctInqRq();
        AcctId acctId = new AcctId();

        acctId.setAcctId(accountId);
        caAcctInqRq.setCaAcctId(acctId);
        caAcctInqRequest.setCaAcctInqRq(caAcctInqRq);

        return caAcctInqRequest;
    }

    private AccountBalanceSourceResponse sourceResponseConverter(FIXML targetResponse, String requestId) {
        AccountBalanceSourceResponse response = new AccountBalanceSourceResponse();
        AccountBalanceSourceResponseBody responseBody = new AccountBalanceSourceResponseBody();

        if(SUCCESS.equalsIgnoreCase(targetResponse.getHeader().getResponseHeader().getHostTransaction().getStatus())){
            CAAcctInqRs caAcctInqRs = targetResponse.getBody().getCaAcctInqResponse().getCaAcctInqRs();
            AcctInqCustomData caAcctInqCustomData = targetResponse.getBody().getCaAcctInqResponse().getCaAcctInqCustomData();

            responseBody.setTransactionCode("00");
            responseBody.setRdInstallmentNumber("");
            responseBody.setRdInstallmentNextDate("");
            responseBody.setCustomerId(caAcctInqRs.getCustId().getCustId());
            responseBody.setAccountRelationship(caAcctInqCustomData.getAcctStat());
            responseBody.setAccountId(caAcctInqRs.getCaAcctId().getAcctId());
            responseBody.setNickName(caAcctInqRs.getCaAcctGenInfo().getAcctShortName());
            responseBody.setName(caAcctInqRs.getCustId().getPersonName().getName());
            responseBody.setBranchId(caAcctInqRs.getCaAcctId().getBankInfo().getBranchId());
            responseBody.setEmailAddress("");

            Product product = Product.builder().group("DDA").type(caAcctInqRs.getCaAcctId().getAcctType().getSchmCode())
                    .description(caAcctInqCustomData.getSchmCodeDesc()).build();

            responseBody.setProduct(product);
            responseBody.setCreationDateTime(DateFormatter.convertDateddMMyyyy(caAcctInqRs.getAcctOpnDt()));
            responseBody.setChequeBookRequested(CHQALLWDFLG_VALUE.equalsIgnoreCase(caAcctInqCustomData.getChqAllwdFlg()) ? YES_FLAG : NO_FLAG);
            responseBody.setModeOfOperation(caAcctInqRs.getModeOfOper());

            Map<String, String> status = fetchStatus(caAcctInqCustomData.getAcctStat(), caAcctInqRs.getBankAcctStatusCode());
            responseBody.setStatus(status.get(STATUS));
            responseBody.setStatusCode(status.get(STATUS_CODE));
            responseBody.setMinBalance("");
            responseBody.setPostalAddress("");

            List<Balance> balances = prepareBalanceData(caAcctInqRs, caAcctInqCustomData, requestId);

            responseBody.setBalance(balances);
            response.setData(responseBody);
        } else if (targetResponse.getBody().getError().getFiSystemException() != null){
            CommonErrorDetail errorDetail = targetResponse.getBody().getError().getFiSystemException().getErrorDetail();
            response.setError(new Error(errorDetail.getErrorCode(), errorDetail.getErrorDesc()));
        } else{
            CommonErrorDetail errorDetail = targetResponse.getBody().getError().getFiBusinessException().getErrorDetail();
            response.setError(new Error(errorDetail.getErrorCode(), errorDetail.getErrorDesc()));
        }
        return response;
    }

    private List<Balance> prepareBalanceData(CAAcctInqRs caAcctInqRs, AcctInqCustomData caAcctInqCustomData, String requestId) {
        List<Balance> balances = new ArrayList<>();
        String amountValue = caAcctInqRs.getAcctBalAmt().getAmountValue();
        String currency = caAcctInqRs.getAcctBalAmt().getCurrencyCode();

        balances.add(createBalance(AVAILABLE_BALANCE, amountValue, currency));
        balances.add(createBalance(LEDGER_BALANCE, amountValue, currency));
        balances.add(createBalance(NET_BALANCE, amountValue, currency));
        balances.add(createBalance(HOLD_BALANCE, null, currency));
        balances.add(createBalance(UNCLEAR_FUNDS, null, currency));

        return balances;
    }

    private Balance createBalance(String type, String amount, String currency) {
        Balance balance = new Balance();
        balance.setType(type);
        balance.setAmount(amount);
        balance.setCurrency(currency);
        return balance;
    }


    private Map<String, String> fetchStatus(String acctStat, String bankAccountStatusCode) {
        Map<String, String> result = new HashMap<>();

        switch (acctStat){
            case "A":
                result.put(STATUS, "Active");
                result.put(STATUS_CODE, "0");
                break;
            case "I":
                result.put(STATUS, "Inactive");
                result.put(STATUS_CODE, "1");
                break;
            case "D":
                result.put(STATUS, "Dormant");
                result.put(STATUS_CODE, "2");
                break;
            case "C":
                result.put(STATUS, "Closed");
                result.put(STATUS_CODE, "4");
                break;
            default:
                result.put(STATUS, acctStat);
                result.put(STATUS_CODE, bankAccountStatusCode);
        }
        return result;
    }

    private BalInqReq prepareBalanceInquiryRequest(FIXML targetResponse, String accountId, String requestId) {
        BalInqReq balInqReq = new BalInqReq();
        balInqReq.setSysTime(DateFormatter.currentDatetimeISO8601WithoutTSSS());
        balInqReq.setAccountId(accountId);
        balInqReq.setAvlBal(targetResponse.getBody().getCaAcctInqResponse().getCaAcctInqRs().getAcctBalAmt().getAmountValue());
        balInqReq.setUserId("");
        balInqReq.setCustId(targetResponse.getBody().getCaAcctInqResponse().getCaAcctInqRs().getCustId().getCustId());
        balInqReq.setBranchId(targetResponse.getBody().getCaAcctInqResponse().getCaAcctInqRs().getCaAcctId().getBankInfo().getBranchId());
        balInqReq.setChannel(requestId);
        balInqReq.setCardNo("");
        balInqReq.setLastTxnDate("");
        balInqReq.setInsertionDate("");
        balInqReq.setAddEntity1("");
        balInqReq.setAddEntity2("");
        balInqReq.setAddEntity3("");
        balInqReq.setAddEntity4("");
        balInqReq.setAddEntity5("");
        return balInqReq;
    }
}
