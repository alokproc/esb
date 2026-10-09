package com.ssfb.account.dto.transactionDetailsByRefNumber.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDetails {

    @JsonProperty(value = "TransactionDate")
    private String transactionDate;

    @JsonProperty(value = "TransactionAmount")
    private String transactionAmount;

    @JsonProperty(value = "TransactionParticulars")
    private String transactionParticulars;

    @JsonProperty(value = "TransactionId")
    private String transactionId;

    @JsonProperty(value = "ForAccountId")
    private String forAccountId;
}
