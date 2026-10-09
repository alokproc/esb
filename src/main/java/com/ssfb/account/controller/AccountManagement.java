package com.ssfb.account.controller;

import com.ssfb.account.dto.opendigitdrd.source.TDRDCreateRequest;
import com.ssfb.account.dto.opendigitdrd.source.TDRDCreateResponse;
import com.ssfb.account.dto.partialrdclose.source.PartialrdcloseRequest;
import com.ssfb.account.dto.partialrdclose.source.PartialrdcloseResponse;
import com.ssfb.account.dto.transactionDetailsByRefNumber.source.TransactionDetailsByReferenceNumberRequest;
import com.ssfb.account.dto.transactionDetailsByRefNumber.source.TransactionDetailsByReferenceNumberResponse;
import com.ssfb.account.service.CreateDigiAccountTDService;
import com.ssfb.account.service.PartTrailClosureService;
import com.ssfb.account.service.TransactionDetailsByReferenceNumberService;
import com.ssfb.commonmodule.utils.HttpRequestUtils;
import com.ssfb.logging.model.LogDetail;
import com.ssfb.logging.model.LogEnvelope;
import com.ssfb.logging.model.LogHeader;
import com.ssfb.logging.service.LoggingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class AccountManagement {

    @Autowired
    private HttpRequestUtils httpRequestUtils;

    @Autowired
    private CreateDigiAccountTDService createDigiAccountTDService;

    @Autowired
    private PartTrailClosureService partTrailClosureService;

    @Autowired
    private TransactionDetailsByReferenceNumberService transactionDetailsByReferenceNumberService;

    private final LoggingService logging= new LoggingService();

    @PostMapping("/account/TDRD")
    public ResponseEntity<TDRDCreateResponse> TDRDcreate(
            @RequestHeader(value="X-Request-ID",required = false) String requestId,
            @RequestHeader(value = "X-Correlation-ID",required = false) String correlationId,
            @Valid@ RequestBody TDRDCreateRequest request)throws Exception {
        if (correlationId == null || correlationId.isEmpty()) {
            correlationId = httpRequestUtils.generateCorrelationID();
        }
        logging.log(new LogEnvelope(new LogHeader("Account", "OpenDigiAccountTDRDV2", "OpenDigiAccountTDRDV2", "OpenDigiAccountTDRDV2", "01", "START", "IN", "INFO", "", correlationId, "", requestId, LocalDateTime.now().toString(), correlationId, "", ""),
                new LogDetail(null, "API Request is : " + httpRequestUtils.writeValueAsString(request))));

        TDRDCreateResponse response = createDigiAccountTDService.createDigiAccountTD(request, correlationId, requestId);

        logging.log(new LogEnvelope(new LogHeader("Account", "OpenDigiAccountTDRDV2", "OpenDigiAccountTDRDV2", "OpenDigiAccountTDRDV2", "01", "END", "OUT", "INFO", "", correlationId, "", requestId, LocalDateTime.now().toString(), correlationId, "", ""),
                new LogDetail(null, "API Response is : " + httpRequestUtils.writeValueAsString(response))));

        return new ResponseEntity<>(response, httpRequestUtils.responseHttpHeaders(correlationId), HttpStatus.OK);
    }

    @PostMapping("/partial/td/tua/close")
    public ResponseEntity<PartialrdcloseResponse> partialrdcloseResponseResponseEntity(
        @RequestHeader(value="X-Request-ID",required = false) String requestId,
        @RequestHeader(value = "X-Correlation-ID",required = false) String correlationId,
        @Valid @RequestBody PartialrdcloseRequest request) throws Exception {
            if (correlationId == null || correlationId.isEmpty()) {
                correlationId = httpRequestUtils.generateCorrelationID();
            }
        logging.log(new LogEnvelope(new LogHeader("Account", "PartialRDClosure", "PartialRDClosure", "PartialRDClosure", "01", "START", "IN", "INFO", "", correlationId, "", requestId, LocalDateTime.now().toString(), correlationId, "", ""),
                new LogDetail(null, "API Request is : " + httpRequestUtils.writeValueAsString(request))));

            PartialrdcloseResponse response = partTrailClosureService.partialrdclose(request,correlationId,requestId);

            return new ResponseEntity<>(response,httpRequestUtils.responseHttpHeaders(correlationId),HttpStatus.OK);

    }

    @PostMapping("/transaction/details/by/referencenumber")
    public ResponseEntity<TransactionDetailsByReferenceNumberResponse> referenceNumber(
            @Valid @RequestBody TransactionDetailsByReferenceNumberRequest request,
            @RequestHeader(value="X-Request-ID",required = false) String requestId,
            @RequestHeader(value = "X-Correlation-ID",required = false) String correlationId) throws Exception {
        if (correlationId == null || correlationId.isEmpty()) {
            correlationId = httpRequestUtils.generateCorrelationID();
        }
        logging.log(new LogEnvelope(new LogHeader("Account", "TransactionDetailsByReferenceNumber", "TransactionDetailsByReferenceNumber", "TransactionDetailsByReferenceNumber", "01", "START", "IN", "INFO", "", correlationId, "", requestId, LocalDateTime.now().toString(), correlationId, "", ""),
                new LogDetail(null, "API Request is : " + httpRequestUtils.writeValueAsString(request))));

        TransactionDetailsByReferenceNumberResponse response = transactionDetailsByReferenceNumberService.transactionDetailsByReferenceNumber(request, correlationId,requestId);

        return new ResponseEntity<>(response,httpRequestUtils.responseHttpHeaders(correlationId),HttpStatus.OK);


    }
}
