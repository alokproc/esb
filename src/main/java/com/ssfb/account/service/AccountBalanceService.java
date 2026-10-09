package com.ssfb.account.service;

import com.ssfb.account.dto.accountbalance.source.AccountBalanceSourceResponse;
import com.ssfb.commonmodule.security.IntentSecuredEncDec;
import com.ssfb.commonmodule.utils.HttpRequestUtils;
import com.ssfb.logging.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.ssfb.account.dto.Constants.VERSION_V2;

@Service
public class AccountBalanceService {
    private final RestTemplate restTemplate;

    @Value("${encdec.pKey}")
    private String pKey;

    @Autowired
    private HttpRequestUtils requestUtils;

    @Autowired
    private SavingsAcctInqService savingsAcctInqService;

    @Autowired
    private CurrentAcctInqService currentAcctInqService;

    private final LoggingService logging = new LoggingService();

    @Autowired
    public AccountBalanceService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public AccountBalanceSourceResponse fetchAccountBalance(String accountId, String token, String version, String correlationId, String requestId) throws Exception{
        accountId = IntentSecuredEncDec.decrypt(accountId, pKey);
        AccountBalanceSourceResponse response = new AccountBalanceSourceResponse();
        if((VERSION_V2.equals(version) && accountId.charAt(2) == '1') || accountId.matches("\\d{10}")){
            response = savingsAcctInqService.savingsAccountInquiry(accountId, token, version, correlationId, requestId);
        } else if(VERSION_V2.equals(version) && (accountId.charAt(2) == '0' || accountId.charAt(2) == '2')){
            response = currentAcctInqService.currentAccountInquiry(accountId, token, version, correlationId, requestId);
        } else{
            // Call DigiAcct
        }
        return response;
    }

}
