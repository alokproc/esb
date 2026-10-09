package com.ssfb.account.service;

import com.ssfb.account.dto.Error;
import com.ssfb.account.dto.accountbalance.acctinq.*;
import com.ssfb.account.dto.accountbalance.common.AcctId;
import com.ssfb.account.dto.accountbalance.common.AcctInqCustomData;
import com.ssfb.account.dto.accountbalance.target.acctinq.*;
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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.ssfb.account.dto.Constants.*;

@Service
public class AccountInquiryService {
    private final RestTemplate restTemplate;

    @Autowired
    private URIBuilderUtil uriBuilderUtil;

    @Autowired
    private HttpRequestUtils requestUtils;

    private final LoggingService logging = new LoggingService();

    @Autowired
    public AccountInquiryService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public AcctInqSourceResponse accountInquiry(String accountId, String token, String version, String correlationId, String requestId) throws Exception{
        AcctInqSourceResponse response = new AcctInqSourceResponse();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);

        try {
            AcctInqFixml fixml = prepareXMLRequestBody(accountId, correlationId, requestId);

            logging.log(new LogEnvelope(new LogHeader("Account","AcctInq","AcctInq","AcctInq","01","OTHER","IN","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null,  "API Request is: "+ requestUtils.writeValueAsString(fixml))));
            ResponseEntity<String> responseEntity = restTemplate.exchange(uriBuilderUtil.accountURI(), HttpMethod.POST, new HttpEntity<>(fixml, headers), String.class);
            logging.log(new LogEnvelope(new LogHeader("Account","AcctInq","AcctInq","AcctInq","01","OTHER","OUT","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null, "API Response is: "+ requestUtils.writeValueAsString(responseEntity.getBody()))));

            AcctInqFixml acctInqFixml = unmarshalXML(responseEntity.getBody());
            response = acctInqSourceConverter(acctInqFixml);
            logging.log(new LogEnvelope(new LogHeader("Account","AcctInq","AcctInq","AcctInq","01","END","OUT","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null, "API Response is: "+ requestUtils.writeValueAsString(response))));
        } catch (HttpClientErrorException e){
            response.setError(new Error(EXCEPTION_ERR_CODE, EXCEPTION_ERR_DESC_TECH));
            logging.log(new LogEnvelope(new LogHeader("Account","AcctInq","AcctInq","AcctInq","01","OTHER","OUT","ERROR","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(new ErrorDetail("01","","",new ErrorDescription(e.getLocalizedMessage(),"01", Arrays.toString(e.getStackTrace())),new ProcessContext("accountInquiry","Test")), "API Response is: "+ requestUtils.writeValueAsString(response))));
        } catch (Exception e) {
            response.setError(new Error(EXCEPTION_ERR_CODE, EXCEPTION_ERR_DESC_GEN));
            logging.log(new LogEnvelope(new LogHeader("Account","AcctInq","AcctInq","AcctInq","01","OTHER","OUT","ERROR","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(new ErrorDetail("01","","",new ErrorDescription(e.getLocalizedMessage(),"01", Arrays.toString(e.getStackTrace())),new ProcessContext("accountInquiry","Test")), "API Response is: "+ requestUtils.writeValueAsString(response))));
        }
        return response;
    }

    private AcctInqFixml prepareXMLRequestBody(String accountId, String correlationId, String requestId) {
        AcctInqFixml fixml = new AcctInqFixml();
        CommonHeaders header = new CommonHeaders();
        Body body = new Body();

        header.setRequestHeader(prepareRequestHeader(correlationId, requestId));
        body.setAcctInqRequest(prepareAcctInqRequest(accountId));

        fixml.setHeader(header);
        fixml.setBody(body);

        return fixml;
    }

    private AcctInqRequest prepareAcctInqRequest(String accountId) {
        AcctInqRequest acctInqRequest = new AcctInqRequest();
        AcctInqRq acctInqRq = new AcctInqRq();
        AcctId acctId = new AcctId();

        acctId.setAcctId(accountId);
        acctInqRq.setAcctId(acctId);
        acctInqRequest.setAcctInqRq(acctInqRq);

        return acctInqRequest;
    }

    private RequestHeader prepareRequestHeader(String correlationId, String requestId) {
        RequestHeader requestHeader = new RequestHeader();
        MessageKey messageKey = new MessageKey();
        RequestMessageInfo requestMessageInfo = new RequestMessageInfo();

        messageKey.setRequestUUID(correlationId);
        messageKey.setServiceRequestId(ACCT_INQ);
        messageKey.setServiceRequestVersion(SERVICE_REQUEST_VERSION);
        messageKey.setChannelId(requestId.substring(0, 3));
        requestHeader.setMessageKey(messageKey);

        requestMessageInfo.setBankId(BANK_ID);
        requestMessageInfo.setMessageDateTime(DateFormatter.currentDateTimeZ());
        requestHeader.setRequestMessageInfo(requestMessageInfo);

        return requestHeader;
    }

    private AcctInqFixml unmarshalXML(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(AcctInqFixml.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        return (AcctInqFixml) unmarshaller.unmarshal(reader);
    }

    private AcctInqSourceResponse acctInqSourceConverter(AcctInqFixml acctInqFixml) {
        AcctInqSourceResponse response = new AcctInqSourceResponse();
        AcctInqSourceResponseBody responseBody = new AcctInqSourceResponseBody();

        if(SUCCESS.equalsIgnoreCase(acctInqFixml.getHeader().getResponseHeader().getHostTransaction().getStatus())){
            AcctInqRs acctInqRs = acctInqFixml.getBody().getAcctInqResponse().getAcctInqRs();
            AcctInqCustomData acctInqCustomData = acctInqFixml.getBody().getAcctInqResponse().getAcctInqCustomData();

            List<AccountBalance> accountBalances = getAccountBalances(acctInqRs);

            List<CustomerStatus> customerStatuses = new ArrayList<>();
            for(CustStat custStat :  acctInqRs.getCustStat()){
                CustomerStatus customerStatus = new CustomerStatus();
                customerStatus.setRefCode(custStat.getRefCode());
                customerStatus.setRefRecType(custStat.getRefRecType());
                customerStatus.setRefDesc(custStat.getRefDesc());

                customerStatuses.add(customerStatus);
            }

            responseBody.setAccountBalance(accountBalances);
            responseBody.setCustomerStatus(customerStatuses);
            responseBody.setAvailableBalanceFlag(acctInqCustomData.getAvailDrCrFlg());
            responseBody.setEffectiveBalanceFlag(acctInqCustomData.getEffBalDrCrFlg());
            responseBody.setLedgerBalanceFlag(acctInqCustomData.getLedgerDrCrFlg());
            response.setData(responseBody);
        } else if (acctInqFixml.getBody().getError().getFiSystemException() != null){
            CommonErrorDetail errorDetail = acctInqFixml.getBody().getError().getFiSystemException().getErrorDetail();
            response.setError(new Error(errorDetail.getErrorCode(), errorDetail.getErrorDesc()));
        } else{
            CommonErrorDetail errorDetail = acctInqFixml.getBody().getError().getFiBusinessException().getErrorDetail();
            response.setError(new Error(errorDetail.getErrorCode(), errorDetail.getErrorDesc()));
        }
        return response;
    }

    private List<AccountBalance> getAccountBalances(AcctInqRs acctInqRs) {
        List<AccountBalance> accountBalances = new ArrayList<>();
        for(AcctBal acctBal : acctInqRs.getAcctBal()){
            AccountBalance accountBalance = new AccountBalance();
            AccountBalanceAmount accountBalanceAmount = new AccountBalanceAmount();

            accountBalanceAmount.setAmountValue(acctBal.getBalAmt().getAmountValue());
            accountBalanceAmount.setCurrencyCode(acctBal.getBalAmt().getCurrencyCode());
            accountBalance.setBalAmt(accountBalanceAmount);
            accountBalance.setBalType(acctBal.getBalType());

            accountBalances.add(accountBalance);
        }
        return accountBalances;
    }
}
