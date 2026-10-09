package com.ssfb.account.dto.rdcountinquirypercustomer.source;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RdCountInquirySourceRequest {
    @JsonProperty(value = "Data")
    public RdCountInquirySourceRequestBody data;

}
