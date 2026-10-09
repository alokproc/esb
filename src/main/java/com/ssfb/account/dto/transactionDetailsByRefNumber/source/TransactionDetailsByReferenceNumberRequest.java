package com.ssfb.account.dto.transactionDetailsByRefNumber.source;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDetailsByReferenceNumberRequest {


    @Valid
    @JsonProperty(value="Data")
    private TransactionDetailsByReferenceNumberRequestBody data;
}
