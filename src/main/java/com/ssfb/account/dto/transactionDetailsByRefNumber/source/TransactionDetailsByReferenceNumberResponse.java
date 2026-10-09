package com.ssfb.account.dto.transactionDetailsByRefNumber.source;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssfb.account.dto.Error;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TransactionDetailsByReferenceNumberResponse {

    @JsonProperty(value = "Data")
    private TransactionDetailsByReferenceNumberResponseBody data;

    @JsonProperty(value = "Error")
    private Error error;
}
