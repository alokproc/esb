package com.ssfb.account.service;

import com.ssfb.account.dto.Error;
import com.ssfb.account.dto.accountbalance.acctinq.AcctInqSourceResponse;
import com.ssfb.account.dto.accountbalance.acctinq.AcctInqSourceResponseBody;
import com.ssfb.account.dto.accountbalance.common.AcctId;
import com.ssfb.account.dto.accountbalance.common.AcctInqCustomData;
import com.ssfb.account.dto.accountbalance.common.RelParty;
import com.ssfb.account.dto.accountbalance.common.RelPartyRec;
import com.ssfb.account.dto.accountbalance.source.*;
import com.ssfb.account.dto.accountbalance.target.balanceinq.BalInqReq;
import com.ssfb.account.dto.accountbalance.target.sbacct.*;
import com.ssfb.account.util.URIBuilderUtil;
import com.ssfb.commonmodule.dto.fixml.*;
import com.ssfb.commonmodule.dto.fixml.CommonErrorDetail;
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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.*;

import static com.ssfb.account.dto.Constants.*;

@Service
public class SavingsAcctInqService {
    private final RestTemplate restTemplate;

    @Autowired
    private URIBuilderUtil uriBuilderUtil;

    @Autowired
    private AccountInquiryService accountInquiryService;

    @Autowired
    private BalanceInquiryService balanceInquiryService;

    @Autowired
    private HttpRequestUtils requestUtils;

    private final LoggingService logging = new LoggingService();

    @Autowired
    public SavingsAcctInqService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public AccountBalanceSourceResponse savingsAccountInquiry(String accountId, String token, String version, String correlationId, String requestId) throws Exception {
        AccountBalanceSourceResponse response = new AccountBalanceSourceResponse();
        AcctInqSourceResponse acctInqResponse = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        try {
            FIXML fixml = prepareXMLRequestBody(accountId, correlationId, requestId);

            logging.log(new LogEnvelope(new LogHeader("Account","SBAcctInq","SBAcctInq","SBAcctInq","01","OTHER","IN","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null,  "API Request is: "+ requestUtils.writeValueAsString(fixml))));
            ResponseEntity<String> responseEntity = restTemplate.exchange(uriBuilderUtil.accountURI(), HttpMethod.POST, new HttpEntity<>(fixml, headers), String.class);

            logging.log(new LogEnvelope(new LogHeader("Account","SBAcctInq","SBAcctInq","SBAcctInq","01","OTHER","OUT","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null, "API Response is: "+ requestUtils.writeValueAsString(responseEntity.getBody()))));

            FIXML targetResponse = unmarshalXML(responseEntity.getBody());

            if (MON.equalsIgnoreCase(requestId)) {
                acctInqResponse = accountInquiryService.accountInquiry(accountId, token, version, correlationId, requestId);
            } else if (M2P.equalsIgnoreCase(requestId) && targetResponse.getBody().getSbAcctInqResponse() != null) {
                BalInqReq balInqReq = prepareBalanceInquiryRequest(targetResponse, accountId, requestId);
                balanceInquiryService.balanceInquiry(balInqReq, correlationId, requestId);
            }

            if (acctInqResponse!= null && acctInqResponse.getError() != null) {
                response.setError(new Error(acctInqResponse.getError().getCode(), acctInqResponse.getError().getDescription()));
                return response;
            }
            response = sourceResponseConverter(targetResponse, acctInqResponse, requestId);
            logging.log(new LogEnvelope(new LogHeader("Account","SBAcctInq","SBAcctInq","SBAcctInq","01","END","OUT","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null, "API Response is: "+ requestUtils.writeValueAsString(response))));
        } catch (HttpClientErrorException e) {
            response.setError(new Error(EXCEPTION_ERR_CODE, EXCEPTION_ERR_DESC_TECH));
            logging.log(new LogEnvelope(new LogHeader("Account","SBAcctInq","SBAcctInq","SBAcctInq","01","OTHER","OUT","ERROR","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(new ErrorDetail("01","","",new ErrorDescription(e.getLocalizedMessage(),"01", Arrays.toString(e.getStackTrace())),new ProcessContext("savingsAccountInquiry","Test")), "API Response is: "+ requestUtils.writeValueAsString(response))));
        } catch (Exception e) {
            response.setError(new Error(EXCEPTION_ERR_CODE, EXCEPTION_ERR_DESC_GEN));
            logging.log(new LogEnvelope(new LogHeader("Account","SBAcctInq","SBAcctInq","SBAcctInq","01","OTHER","OUT","ERROR","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(new ErrorDetail("01","","",new ErrorDescription(e.getLocalizedMessage(),"01", Arrays.toString(e.getStackTrace())),new ProcessContext("savingsAccountInquiry","Test")), "API Response is: "+ requestUtils.writeValueAsString(response))));
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
        body.setSbAcctInqRequest(prepareSbAcctInqRequest(accountId));

        fixml.setHeader(header);
        fixml.setBody(body);

        return fixml;
    }

    private RequestHeader prepareRequestHeader(String correlationId, String requestId) {
        RequestHeader requestHeader = new RequestHeader();
        MessageKey messageKey = new MessageKey();
        RequestMessageInfo requestMessageInfo = new RequestMessageInfo();

        messageKey.setRequestUUID(correlationId);
        messageKey.setServiceRequestId(SB_ACCT_INQ);
        messageKey.setServiceRequestVersion(SERVICE_REQUEST_VERSION);
        messageKey.setChannelId(requestId.substring(0, 3));
        requestHeader.setMessageKey(messageKey);

        requestMessageInfo.setBankId(BANK_ID);
        requestMessageInfo.setMessageDateTime(DateFormatter.currentDateTimeZ());
        requestHeader.setRequestMessageInfo(requestMessageInfo);

        return requestHeader;
    }

    private SBAcctInqRequest prepareSbAcctInqRequest(String accountId) {
        SBAcctInqRequest sbAcctInqRequest = new SBAcctInqRequest();
        SBAcctInqRq sbAcctInqRq = new SBAcctInqRq();
        AcctId acctId = new AcctId();

        acctId.setAcctId(accountId);
        sbAcctInqRq.setSbAcctId(acctId);
        sbAcctInqRequest.setSbAcctInqRq(sbAcctInqRq);

        return sbAcctInqRequest;
    }

    private AccountBalanceSourceResponse sourceResponseConverter(FIXML targetResponse, AcctInqSourceResponse acctInqResponse, String requestId) {
        AccountBalanceSourceResponse response = new AccountBalanceSourceResponse();
        AccountBalanceSourceResponseBody responseBody = new AccountBalanceSourceResponseBody();

        if(SUCCESS.equalsIgnoreCase(targetResponse.getHeader().getResponseHeader().getHostTransaction().getStatus())){
            SBAcctInqRs sbAcctInqRs = targetResponse.getBody().getSbAcctInqResponse().getSbAcctInqRs();
            AcctInqCustomData sbAcctInqCustomData = targetResponse.getBody().getSbAcctInqResponse().getSbAcctInqCustomData();


            responseBody.setTransactionCode("00");
            responseBody.setRdInstallmentNumber("");
            responseBody.setRdInstallmentNextDate("");
            responseBody.setCustomerId(sbAcctInqRs.getCustId().getCustId());
            responseBody.setAccountRelationship(sbAcctInqCustomData.getAcctStat());
            responseBody.setAccountId(sbAcctInqRs.getSbAcctId().getAcctId());
            responseBody.setNickName(sbAcctInqRs.getSbAcctGenInfo().getAcctShortName());
            responseBody.setName(sbAcctInqRs.getCustId().getPersonName().getName());
            responseBody.setBranchId(sbAcctInqRs.getSbAcctId().getBankInfo().getBranchId());
            responseBody.setEmailAddress("");

            Product product = Product.builder().group("DDA").type(sbAcctInqRs.getSbAcctId().getAcctType().getSchmCode())
                                                        .description(sbAcctInqCustomData.getSchmCodeDesc()).build();

            responseBody.setProduct(product);
            responseBody.setCreationDateTime(DateFormatter.convertDateddMMyyyy(sbAcctInqRs.getAcctOpnDt()));
            responseBody.setChequeBookRequested(CHQALLWDFLG_VALUE.equalsIgnoreCase(sbAcctInqCustomData.getChqAllwdFlg()) ? YES_FLAG : NO_FLAG);
            responseBody.setModeOfOperation(sbAcctInqRs.getModeOfOper());

            Map<String, String> status = fetchStatus(sbAcctInqCustomData.getAcctStat(), sbAcctInqRs.getBankAcctStatusCode());
            responseBody.setStatus(status.get(STATUS));
            responseBody.setStatusCode(status.get(STATUS_CODE));
            responseBody.setMinBalance("");
            responseBody.setPostalAddress("");

            List<Balance> balances = prepareBalanceData(sbAcctInqRs, sbAcctInqCustomData, acctInqResponse, requestId);

            responseBody.setBalance(balances);
            responseBody.setDrawingPower(sbAcctInqCustomData.getDrawingPower());
            responseBody.setDrawingPowerIndices(sbAcctInqCustomData.getDrawingPowerInd());
            responseBody.setNetInterestRate(sbAcctInqCustomData.getNetIntRate());
            responseBody.setSanctionLimit(sbAcctInqCustomData.getSanctLimit());
            responseBody.setSanctionDate(sbAcctInqCustomData.getSanctDate());
            responseBody.setSanctionExpiryDate(sbAcctInqCustomData.getExpiryDate());

            List<RelPartyRec> relPartyRecList = sbAcctInqRs.getRelPartyRec();
            List<Relparty> relpartyList = new ArrayList<>();

            if (relPartyRecList!=null){
                for (RelPartyRec relPartyReclist : relPartyRecList ){
                    Relparty relparty = new Relparty();

                    relparty.setType(relPartyReclist.getRelPartyType());
                    relparty.setCode(relPartyReclist.getRelPartyCode());
                    relparty.setCustomerId(String.valueOf(relPartyReclist.getCustId()));
                    relparty.setRecordDeleteFlag(relPartyReclist.getRecDelFlg());

                    relpartyList.add(relparty);
                }
            }
            responseBody.setRelParty(relpartyList);

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

    private List<Balance> prepareBalanceData(SBAcctInqRs sbAcctInqRs, AcctInqCustomData sbAcctInqCustomData, AcctInqSourceResponse acctInqResponse, String requestId) {
        List<Balance> balances = new ArrayList<>();
        String amountValue = sbAcctInqRs.getAcctBalAmt().getAmountValue();
        String currency = sbAcctInqRs.getAcctBalAmt().getCurrencyCode();
        boolean isMonRequest = MON.equalsIgnoreCase(requestId);

        String availableFlag = null;
        String ledgerFlag = null;
        String netFlag = null;

        if (isMonRequest && acctInqResponse != null && acctInqResponse.getData() != null) {
            AcctInqSourceResponseBody responseData = acctInqResponse.getData();
            availableFlag = responseData.getAvailableBalanceFlag();
            ledgerFlag = responseData.getLedgerBalanceFlag();
            netFlag = responseData.getEffectiveBalanceFlag();
        }

        balances.add(createBalance(AVAILABLE_BALANCE, amountValue, currency, availableFlag));
        balances.add(createBalance(LEDGER_BALANCE, amountValue, currency, ledgerFlag));
        balances.add(createBalance(NET_BALANCE, amountValue, currency, netFlag));
        balances.add(createBalance(HOLD_BALANCE, null, currency, null));
        balances.add(createBalance(UNCLEAR_FUNDS, null, currency, null));

        return balances;
    }

    private Balance createBalance(String type, String amount, String currency, String creditDebitFlag) {
        Balance balance = new Balance();
        balance.setType(type);
        balance.setAmount(amount);
        balance.setCurrency(currency);
        if (creditDebitFlag != null && !creditDebitFlag.isEmpty()) {
            balance.setCreditDebitFlag(creditDebitFlag);
        }
        return balance;
    }


    private Map<String, String> fetchStatus(String acctStat, String bankAcctStatusCode) {
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
                result.put(STATUS, bankAcctStatusCode);
                result.put(STATUS_CODE, bankAcctStatusCode);
        }
        return result;
    }

    private BalInqReq prepareBalanceInquiryRequest(FIXML targetResponse, String accountId, String requestId) {
        BalInqReq balInqReq = new BalInqReq();
        balInqReq.setSysTime(DateFormatter.currentDatetimeISO8601WithoutTSSS());
        balInqReq.setAccountId(accountId);
        balInqReq.setAvlBal(targetResponse.getBody().getSbAcctInqResponse().getSbAcctInqRs().getAcctBalAmt().getAmountValue());
        balInqReq.setUserId("");
        balInqReq.setCustId(targetResponse.getBody().getSbAcctInqResponse().getSbAcctInqRs().getCustId().getCustId());
        balInqReq.setBranchId(targetResponse.getBody().getSbAcctInqResponse().getSbAcctInqRs().getSbAcctId().getBankInfo().getBranchId());
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
