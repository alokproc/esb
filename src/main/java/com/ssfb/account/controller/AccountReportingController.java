package com.ssfb.account.controller;

import com.ssfb.account.dto.accountbalance.source.AccountBalanceSourceResponse;
import com.ssfb.account.dto.fetchutrdetails.source.FetchUtrDetailsSourceRequest;
import com.ssfb.account.dto.fetchutrdetails.source.FetchUtrDetailsSourceResponse;
import com.ssfb.account.dto.loanstatement.source.LoanAccountStatementRequest;
import com.ssfb.account.dto.loanstatement.source.LoanAccountStatementResponse;
import com.ssfb.account.dto.rdcountinquirypercustomer.source.RdCountInquirySourceRequest;
import com.ssfb.account.dto.rdcountinquirypercustomer.source.RdCountInquirySourceResponse;
import com.ssfb.account.service.AccountBalanceService;
import com.ssfb.account.service.FetchUtrDetailsService;
import com.ssfb.account.service.LoanAccountStatementService;
import com.ssfb.account.service.RdCountInquiryService;
import com.ssfb.logging.model.LogDetail;
import com.ssfb.logging.model.LogEnvelope;
import com.ssfb.logging.model.LogHeader;
import com.ssfb.logging.service.LoggingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.ssfb.commonmodule.utils.HttpRequestUtils;

import java.time.LocalDateTime;

@Controller
public class AccountReportingController {

    @Autowired
    private AccountBalanceService accountBalanceService;

    @Autowired
    private LoanAccountStatementService loanAccountStatementService;

    @Autowired
    private RdCountInquiryService rdCountInquiryService;

    @Autowired
    private FetchUtrDetailsService fetchUtrDetailsService;

    @Autowired
    private HttpRequestUtils requestUtils;

    private final LoggingService logging = new LoggingService();

    @GetMapping("accounts/{accountId}/balance")
    public ResponseEntity<AccountBalanceSourceResponse> fetchAccountBalances(
            @RequestHeader(value="X-Request-ID",required = false) String requestId,
            @RequestHeader(value = "X-Correlation-ID",required = false) String correlationId,
            @RequestHeader(value = "version",required = false) String version,
            @PathVariable("accountId") String accountId,
            @RequestHeader(value = "Authorization", required = false) String token) throws Exception{
        if(correlationId == null || correlationId.isEmpty()) {
            correlationId = requestUtils.generateCorrelationID();
        }

        logging.log(new LogEnvelope(new LogHeader("Account","Fetch Account Balance","Fetch Account Balance","Fetch Account Balance","01","START","IN","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId, "",""),
                new LogDetail(null, "Account ID : " + accountId)));

        AccountBalanceSourceResponse response = accountBalanceService.fetchAccountBalance(accountId, token, version, correlationId, requestId);
        return new ResponseEntity<>(response, requestUtils.responseHttpHeaders(correlationId), HttpStatus.OK);
    }


    @PostMapping("/loan/account/statement")
    public ResponseEntity<LoanAccountStatementResponse> fetchAccountBalances(
            @RequestHeader(value="X-Request-ID",required = false) String requestId,
            @RequestHeader(value = "X-Correlation-ID",required = false) String correlationId,
            @Valid @RequestBody LoanAccountStatementRequest request) throws Exception{
        if(correlationId == null || correlationId.isEmpty()) {
            correlationId = requestUtils.generateCorrelationID();
        }

        logging.log(new LogEnvelope(new LogHeader("Account","Loan Account Statement","Loan Account Statement","Loan Account Statement","01","START","IN","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId, "",""),
                new LogDetail(null, "API Request is : " + requestUtils.writeValueAsString(request))));

        LoanAccountStatementResponse response = loanAccountStatementService.fetchLoanAccountStatement(request, correlationId, requestId);

        logging.log(new LogEnvelope(new LogHeader("Account","Loan Account Statement","Loan Account Statement","Loan Account Statement","01","END","OUT","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId, "",""),
                new LogDetail(null, "API Response is : " + requestUtils.writeValueAsString(response))));
        return new ResponseEntity<>(response, requestUtils.responseHttpHeaders(correlationId), HttpStatus.OK);
    }

    @PostMapping(path = "/rd/count/inquiry")
    public ResponseEntity<RdCountInquirySourceResponse> rdCountInquiry(@RequestBody RdCountInquirySourceRequest request,
                                                                       @RequestHeader(value = "X-Request-ID", required = false) String requestId,
                                                                       @RequestHeader(value = "X-Correlation-ID", required = false) String correlationId) throws Exception {
        if (correlationId == null || correlationId.isEmpty()) {
            correlationId =requestUtils.generateCorrelationID();
        }

        logging.log(new LogEnvelope(new LogHeader("AccountManagement", "RdCountInquiry", "RdCountInquiry", "RdCountInquiry", "01", "START", "IN", "INFO", "", correlationId, "", requestId, LocalDateTime.now().toString(), correlationId, "", ""),
                new LogDetail(null, "API Request is: " + requestUtils.writeValueAsString(request))));

        RdCountInquirySourceResponse response=rdCountInquiryService.rdCountInquiryFunction(request,correlationId,requestId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("X-Correlation-ID", correlationId);
        headers.add("X-TimeStamp", String.valueOf(LocalDateTime.now()));
        return new ResponseEntity<>(response,headers, HttpStatus.OK);

    }
    @PostMapping(path = "/fetch/utr/details")
    public ResponseEntity<FetchUtrDetailsSourceResponse> fetchUtrDetailsEntity (
            @RequestBody FetchUtrDetailsSourceRequest request,
            @RequestHeader(value = "X-Request-ID", required = false) String requestId,
            @RequestHeader(value = "X-Correlation-ID", required = false) String correlationId) throws Exception {

        if (correlationId == null || correlationId.isEmpty()) {
            correlationId =requestUtils.generateCorrelationID();
        }

        logging.log(new LogEnvelope(new LogHeader("Account", "FetchUtrDetails", "FetchUtrDetails", "FetchUtrDetails", "01", "START", "IN", "INFO", "", correlationId, "", requestId, LocalDateTime.now().toString(), correlationId, "", ""),
                new LogDetail(null, "API Request is: " + requestUtils.writeValueAsString(request))));


        FetchUtrDetailsSourceResponse response= fetchUtrDetailsService.fetchUtrDetailsFunction(request,correlationId,requestId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("X-Correlation-ID", correlationId);
        headers.add("X-TimeStamp", String.valueOf(LocalDateTime.now()));
        return new ResponseEntity<>(response,headers, HttpStatus.OK);

    }


}
