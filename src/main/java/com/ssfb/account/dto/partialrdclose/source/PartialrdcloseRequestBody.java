package com.ssfb.account.dto.partialrdclose.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PartialrdcloseRequestBody {

    @JsonProperty(value="Operation")
    private String operation;

    @JsonProperty(value="AccountNumber")
    private String accountNumber;

    @JsonProperty(value="RePaymentAccount")
    private String rePaymentAccount;

    @JsonProperty(value="ClearValueDate")
    private String clearValueDate;

    @JsonProperty(value="RePaymentMode")
    private String rePaymentMode;

    @JsonProperty(value="ClosureReason")
    private String closureReason;

    @JsonProperty(value="ClousreAmount")
    private String clousreAmount;



}
