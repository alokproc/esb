package com.ssfb.account.controller;

import com.ssfb.account.dto.rrninquiry.source.RRNInquirySourceRequest;
import com.ssfb.account.dto.rrninquiry.source.RRNInquirySourceResponse;
import com.ssfb.account.service.BrdRrnInquiryService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.time.LocalDateTime;

@Controller
public class BRDController {

    @Autowired
    private BrdRrnInquiryService brdRrnInquiryService;

    @Autowired
    private HttpRequestUtils requestUtils;

    private final LoggingService logging = new LoggingService();

    @PostMapping("/brd/rrn/inquiry")
    public ResponseEntity<RRNInquirySourceResponse> brdRrnInquiry(
            @RequestHeader(value="X-Request-ID",required = false) String requestId,
            @RequestHeader(value = "X-Correlation-ID",required = false) String correlationId,
            @Valid @RequestBody RRNInquirySourceRequest request) throws Exception {
        if(correlationId == null || correlationId.isEmpty()) {
            correlationId = requestUtils.generateCorrelationID();
        }

        logging.log(new LogEnvelope(new LogHeader("Account","RRNInquiry","RRNInquiry","RRNInquiry","01","START","IN","INFO","", correlationId,"", requestId, LocalDateTime.now().toString(), correlationId, "",""),
                new LogDetail(null, "API Request is : " + requestUtils.writeValueAsString(request))));

        RRNInquirySourceResponse response = brdRrnInquiryService.rrnInquiry(request.getData(), correlationId, requestId);
        return new ResponseEntity<>(response, requestUtils.responseHttpHeaders(correlationId), HttpStatus.OK);
    }
}
