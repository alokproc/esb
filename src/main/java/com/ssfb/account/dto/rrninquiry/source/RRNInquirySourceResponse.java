package com.ssfb.account.dto.rrninquiry.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssfb.commonmodule.dto.Error;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RRNInquirySourceResponse {
    @JsonProperty(value = "Data")
    public RRNInquirySourceResponseBody data;

    @JsonProperty(value = "Error")
    public Error error;
}
