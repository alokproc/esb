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
public class RdCountInquirySourceResponseBody {

    @JsonProperty(value = "TransactionCode")
    private String transactionCode;

    @JsonProperty(value = "Status")
    private String status;

    @JsonProperty(value = "ResponseMessage")
    private String responseMessage;

}
