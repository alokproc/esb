package com.ssfb.account.dto.rrninquiry.source;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RRNInquirySourceResponseBody {
    @JsonProperty(value = "TransactionCode")
    private String transactionCode;

    @JsonProperty(value = "TransactionDate")
    private String transactionDate;

    @JsonProperty(value = "TransactionAmount")
    private String transactionAmount;

    @JsonProperty(value = "CustomerName")
    private String customerName;

    @JsonProperty(value = "CustomerAccount")
    private String customerAccount;

    @JsonProperty(value = "CustomerMobile")
    private String customerMobile;

    @JsonProperty(value = "CustomerIfsc")
    private String customerIfsc;

    @JsonProperty(value = "ResultMessage")
    private String resultMsg;
}
