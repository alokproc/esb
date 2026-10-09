package com.ssfb.account.dto.partialrdclose.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartialrdcloseResponseBody {

    @JsonProperty(value = "TransactionCode")
    private String transactionCode;

    @JsonProperty(value = "SuccessOrFailure")
    private String successOrFailure;

    @JsonProperty(value = "DepositAmount")
    private String depositAmount;

    @JsonProperty(value = "EffectiveInterestPercent")
    private String effectiveInterestPercent;

    @JsonProperty(value = "NormalInterestPercent")
    private String normalInterestPercent;

    @JsonProperty(value = "NetInterestPaid")
    private String netInterestPaid;

    @JsonProperty(value = "NormalInterestAmount")
    private String normalInterestAmount;

    @JsonProperty(value = "PenalInterestAmount")
    private String penalInterestAmount;

    @JsonProperty(value = "PenaltyAmount")
    private String penaltyAmount;

    @JsonProperty(value = "RepaymentAccountId")
    private String repaymentAccountId;

    @JsonProperty(value = "FDClosureAmount")
    private String fdClosureAmount;

    @JsonProperty(value = "Message")
    private String message;

    //Response Tags for TD Closure

    @JsonProperty(value = "TransactionId")
    private String transactionId;

    @JsonProperty(value = "TransactionDate")
    private String transactionDate;



}
