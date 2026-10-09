package com.ssfb.account.dto.opendigitdrd.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Beneficiary {

    @JsonProperty("BranchId")
    private String branchId;

    @Pattern(
            regexp = "^([a-zA-Z0-9][a-zA-Z0-9\\w\\s/#\\-:,\\.]*)*$",
            message = "Invalid BranchName"
    )
    @JsonProperty("BranchName")
    private String branchName;

    @Size(max = 20, message = "AccountId length must be between 0 and 20")
    @Pattern(
            regexp = "^[a-zA-Z0-9]*$",
            message = "Invalid AccountId"
    )
    @JsonProperty("AccountId")
    private String accountId;

    @Size(max = 20, message = "AccountType length must be between 0 and 20")
    @Pattern(
            regexp = "^[a-zA-Z0-9]*$",
            message = "Invalid AccountType"
    )
    @JsonProperty("AccountType")
    private String accountType;

    @Pattern(
            regexp = "^[a-zA-Z0-9]*$",
            message = "Invalid IFSCCode"
    )
    @JsonProperty("IFSCCode")
    private String ifscCode;

    @Pattern(
            regexp = "^[a-zA-Z0-9]*$",
            message = "Invalid TransactionType"
    )
    @JsonProperty("TransactionType")
    private String transactionType;
}

