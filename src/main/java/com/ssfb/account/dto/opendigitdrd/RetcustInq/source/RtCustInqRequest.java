package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RtCustInqRequest {

    @JsonProperty("Header")
    private Header header;

    @JsonProperty("Data")
    private RtCustInqRequestBody rtCustInqRequestBody;

    @JsonProperty("Method")
    private String method;

}
