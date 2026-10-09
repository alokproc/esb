package com.ssfb.account.service.helper;

import com.ssfb.account.config.AccountConfig;
import com.ssfb.account.dto.opendigitdrd.RetcustInq.source.*;
import com.ssfb.account.dto.opendigitdrd.RetcustInq.target.*;
import com.ssfb.commonmodule.dto.Error;
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
import jakarta.xml.bind.Unmarshaller;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.StringReader;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.ssfb.account.dto.Constants.*;

@Component
public class RetCustInqHelper {

    private final RestTemplate restTemplate;
    private final LoggingService logging = new LoggingService();

    @Autowired
    private AccountConfig accountConfig;

    @Autowired
    private HttpRequestUtils httpRequestUtils;

    @Autowired
    private RetCustInqHelper(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public RtCustInqResponse retCustInq(RtCustInqRequest request, String correlationId, String requestId){
        RtCustInqResponse response = new RtCustInqResponse();
        FIXML targetResponse = new FIXML();
        FIXML targetRequest = prepareTargetRequest(request,correlationId,requestId);
        try {
            logging.log(new LogEnvelope(new LogHeader("Account","RetCustInq","RetCustInq","RetCustInq","01","OTHER","IN","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null,  "API Request is: "+ httpRequestUtils.writeValueAsString(targetRequest))));

           targetResponse = esbrestAPICALL(restTemplate,targetRequest);

            logging.log(new LogEnvelope(new LogHeader("Account","RetCustInq","RetCustInq","RetCustInq","01","END","OUT","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId,"",""),
                    new LogDetail(null,  "API Response is: "+ httpRequestUtils.writeValueAsString(targetResponse))));

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
        return response;

    }


    private FIXML prepareTargetRequest(RtCustInqRequest request, String correlationId, String requestId){
        FIXML fixml = new FIXML();
        CommonHeaders headers = new CommonHeaders();
        Body body = new Body();

        headers.setRequestHeader(prepareRequestHeader(correlationId,requestId));
        body.setRetCustInqRequest(prepareRetCustInqRequest(request));

        fixml.setHeader(headers);
        fixml.setBody(body);
        return fixml;
    }

    private RequestHeader prepareRequestHeader(String correlationId, String requestId){
        RequestHeader requestHeader = new RequestHeader();
        MessageKey messageKey = new MessageKey();
        RequestMessageInfo requestMessageInfo = new RequestMessageInfo();

        messageKey.setRequestUUID(correlationId);
        messageKey.setServiceRequestId("RetCustInq");
        messageKey.setServiceRequestVersion("10.2");
        if (requestId!=null && requestId.length() >=3) {
            messageKey.setChannelId(requestId.substring(0,3));
        } else {
            messageKey.setChannelId(requestId);
        }
        requestMessageInfo.setBankId(BANK_ID);
        requestMessageInfo.setMessageDateTime(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));

        requestHeader.setMessageKey(messageKey);
        requestHeader.setRequestMessageInfo(requestMessageInfo);

        return requestHeader;
    }
    private RetCustInqRequest prepareRetCustInqRequest(RtCustInqRequest request){
        RetCustInqRequest retCustInqRequest = new RetCustInqRequest();
        RetCustInqRq retCustInqRq = new RetCustInqRq();

        retCustInqRq.setCustId(request.getRtCustInqRequestBody().getCustomerNo());
        retCustInqRequest.setRetCustInqRq(retCustInqRq);

        return retCustInqRequest;

    }
    private URI URIBuilder(){
        return UriComponentsBuilder.newInstance().scheme(accountConfig.getProtocol()).host(accountConfig.getHostname()).port(accountConfig.getPort()).path(accountConfig.getPath()).build().toUri();
    }

    private FIXML unmarshalXML(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FIXML.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        return (FIXML) unmarshaller.unmarshal(reader);
    }

    private FIXML esbrestAPICALL(RestTemplate restTemplate,FIXML targetRequest) throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        ResponseEntity<String> response =restTemplate.exchange(URIBuilder(), HttpMethod.POST , new HttpEntity<>(targetRequest,headers), String.class);
        return unmarshalXML(response.getBody());

    }

    private RtCustInqResponse prepareSourceResponse(FIXML fixml){
        RtCustInqResponse rtCustInqResponse = new RtCustInqResponse();
        RtCustInqResponseBody rtCustInqResponseBody = new RtCustInqResponseBody();
//        AccountDetails accountDetails =new AccountDetails();
//        AccountDtls accountDtls = new AccountDtls();
//        Address address = new Address();
//        AddressDet addressDet = new AddressDet();
//        AddressDetails addressDetails = new AddressDetails();
//        BrNetLoanDetails brNetLoanDetails = new BrNetLoanDetails();
//        ClientDemiseDetails clientDemiseDetails =new ClientDemiseDetails();
//        ContactInfo contactInfo =new ContactInfo();
//        CRMCustDataResponse crmCustDataResponse = new CRMCustDataResponse();
          CustomerDetails customerDetails =new CustomerDetails();
//        DepositDetails depositDetails = new DepositDetails();
//        DocumentDtls documentDtls =new DocumentDtls();
//        GetCorporateCustomerDetailsCustomData getCorporateCustomerDetailsCustomData =new GetCorporateCustomerDetailsCustomData();
//        GstDetails gstDetails =new GstDetails();
//        HolidayPeriodDtls holidayPeriodDtls = new HolidayPeriodDtls();
//        InstallmentFreq installmentFreq = new InstallmentFreq();
//        JointHolderDemiseDetails jointHolderDemiseDetails = new JointHolderDemiseDetails();
//        JointHolderDtls jointHolderDtls = new JointHolderDtls();
//        KycDet kycDet = new KycDet();
//        KycDetails kycDetails = new KycDetails();
//        LoanDtls loanDtls = new LoanDtls();
//        Maturity maturity = new Maturity();
//        Party party = new Party();
//        PaymentDtls paymentDtls = new PaymentDtls();
//        Principal principal = new Principal();
//        Product product = new Product();
//        ProfileLoanDetails profileLoanDetails = new ProfileLoanDetails();
//        RescheduleDtls rescheduleDtls = new RescheduleDtls();
//          Error error = new Error();

        List<CustomerDetails> customerDetailsList= new ArrayList<>();

        if (fixml.getHeader().getResponseHeader().getHostTransaction().getStatus().equalsIgnoreCase("SUCCESS")){
            customerDetails.setIsMinor(fixml.getBody().getRetCustInqResponse().getRetCustInqRs().getRetCustDtls().getIsMinor());
            rtCustInqResponseBody.setTransactionCode("00");
            Optional<String> panrefNum = Optional.ofNullable(fixml.getBody().getRetCustInqResponse().getRetCustInqRs().getEntityDocDtls()).orElse(Collections.emptyList())
                    .stream().filter(e -> "6".equals(e.getDocCode())).map(EntityDocDtls::getRefNum).findFirst();
            panrefNum.ifPresent(customerDetails::setPanNumber);
            Optional<String> form60RefNum = Optional.ofNullable(fixml.getBody().getRetCustInqResponse().getRetCustInqRs().getEntityDocDtls()).orElse(Collections.emptyList())
                    .stream().filter(e -> "67".equals(e.getDocCode())).map(EntityDocDtls::getRefNum).findFirst();
            form60RefNum.ifPresent(customerDetails::setForm60);
            customerDetailsList.add(customerDetails);
            rtCustInqResponseBody.setCustomerDetails(customerDetailsList);
            rtCustInqResponse.setData(rtCustInqResponseBody);
        }else {
            if (fixml.getBody().getError().getFiSystemException()!=null)
                rtCustInqResponse.setError(new Error(fixml.getBody().getError().getFiSystemException().getErrorDetail().getErrorCode(),fixml.getBody().getError().getFiSystemException().getErrorDetail().getErrorDesc()));
            if (fixml.getBody().getError().getFiBusinessException()!=null)
                rtCustInqResponse.setError(new Error(fixml.getBody().getError().getFiBusinessException().getErrorDetail().getErrorCode(),fixml.getBody().getError().getFiBusinessException().getErrorDetail().getErrorDesc()));
        }
        return rtCustInqResponse;





    }






}
