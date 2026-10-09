package com.ssfb.account.dto.transactionDetailsByRefNumber.source;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TransactionDetailsByReferenceNumberResponseBody {

    @JsonProperty(value = "TransactionCode")
    private String transactionCode;

    @JsonProperty(value = "TransactionDetails")
    private List<TransactionDetails> transactionDetails;
}
