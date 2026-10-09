package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Header {
    @JsonProperty("X-Correlation-ID")
    private String xCorrelationId;

    @JsonProperty("X-Request-ID")
    private String xRequestId;

    @JsonProperty("UserID")
    private String userID;

    @JsonProperty("X-From-ID")
    private String xFromId;

    @JsonProperty("X-To-ID")
    private String xToId;

    @JsonProperty("X-Transaction-ID")
    private String xTransactionId;

}
