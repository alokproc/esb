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
public class RdCountInquirySourceRequestBody {

    @JsonProperty(value = "CustomerId")
    private String customerId;

    @JsonProperty(value = "Status")
    private String status;

}
