package com.ssfb.account.dto.opendigitdrd.source;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TDRDCreateResponseBody {

    @JsonProperty("AccountId")
    private String accountId;

    @JsonProperty("TransactionCode")
    private String transactionCode;

    @JsonProperty("RMCode")
    private String rmCode;

    @JsonProperty("PlanCode")
    private String planCode;

    @JsonProperty("PlanId")
    private String planId;


}
