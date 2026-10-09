package com.ssfb.account.service.helper;

import com.ssfb.account.config.TDRDDetailsBankingConfig;
import com.ssfb.account.dto.opendigitdrd.tdrddetails.TDRDDetailsResponse;
import com.ssfb.commonmodule.utils.HttpRequestUtils;
import com.ssfb.logging.model.LogDetail;
import com.ssfb.logging.model.LogEnvelope;
import com.ssfb.logging.model.LogHeader;
import com.ssfb.logging.service.LoggingService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Collections;

@Component
public class TDRDDetailsHelper {

    private final RestTemplate restTemplate;

    private final LoggingService logging= new LoggingService();

    @Autowired
    private TDRDDetailsBankingConfig tdrdDetailsBankingConfig;

    @Autowired
    private HttpRequestUtils httpRequestUtils;

    @Autowired
    private TDRDDetailsHelper(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public TDRDDetailsResponse tdrdDetails(String accountID,String correlationId, String requestId){
        TDRDDetailsResponse response = new TDRDDetailsResponse();
        try{
            logging.log(new LogEnvelope(new LogHeader("Account","TDRDDetails","TDRDDetails","TDRDDetails","01","OTHER","IN","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null,  "API Request is: "+ accountID)));

            response =esbRESTAPICALL(restTemplate,accountID,correlationId,requestId);

            logging.log(new LogEnvelope(new LogHeader("Account","TDRDDetails","TDRDDetails","TDRDDetails","01","END","OUT","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null,  "API Request is: "+ response)));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
    private TDRDDetailsResponse esbRESTAPICALL(RestTemplate restTemplate, String accountID, String correlationId, String requestId) throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        headers.add("X-Correlation-ID", requestId + correlationId);
        headers.add("X-Request-ID", requestId);
        headers.add("version","v2");

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<TDRDDetailsResponse> response = this.restTemplate.exchange(uriBuilder(accountID), HttpMethod.GET, entity ,TDRDDetailsResponse.class);
        return response.getBody();
    }

    private URI uriBuilder(String accountID){
        return UriComponentsBuilder.newInstance().scheme(tdrdDetailsBankingConfig.getProtocol()).host(tdrdDetailsBankingConfig.getHostname()).port(tdrdDetailsBankingConfig.getPort()).path(tdrdDetailsBankingConfig.getResourcePath().replace("{accountID}",accountID)).build().toUri();

    }
}
