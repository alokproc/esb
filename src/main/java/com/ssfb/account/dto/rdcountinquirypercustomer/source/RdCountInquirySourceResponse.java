package com.ssfb.account.dto.rdcountinquirypercustomer.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RdCountInquirySourceResponse {

    @JsonProperty(value = "Data")
    public RdCountInquirySourceResponseBody data;

    @JsonProperty(value = "Error")
    public Error error;

}
