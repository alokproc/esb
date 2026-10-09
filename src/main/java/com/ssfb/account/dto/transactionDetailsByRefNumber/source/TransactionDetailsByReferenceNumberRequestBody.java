package com.ssfb.account.dto.transactionDetailsByRefNumber.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDetailsByReferenceNumberRequestBody {

    @JsonProperty(value = "ReferenceNumber")
    private String referenceNumber;


}
