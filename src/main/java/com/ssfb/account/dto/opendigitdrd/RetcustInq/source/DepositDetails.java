package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepositDetails {

    @JsonProperty("AccountId")
    private String accountId;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("OriginalAmount")
    private String originalAmount;

    @JsonProperty("ModeOfOperation")
    private String modeOfOperation;

    @JsonProperty("Relationship")
    private String relationship;

    @JsonProperty("CreationDate")
    private String creationDate;

    @JsonProperty("Maturity")
    private Maturity maturity;

    @JsonProperty("BranchCode")
    private String branchCode;

    @JsonProperty("InterestRate")
    private String interestRate;

    @JsonProperty("DepositFrequency")
    private String depositFrequency;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("IPF")
    private String ipf;

    @JsonProperty("LOPT")
    private String lopt;

    @JsonProperty("Party")
    private Party party;

    @JsonProperty("MBEnabled")
    private String mbEnabled;

    @JsonProperty("WAEnabled")
    private String waEnabled;

    @JsonProperty("IsEBEnabled")
    private String isEBEnabled;

    @JsonProperty("AccountSolId")
    private String accountSolId;

    @JsonProperty("SchemeDescription")
    private String schemeDescription;

    @JsonProperty("AccountCloseDate")
    private String accountCloseDate;

    @JsonProperty("AccountCloseFlag")
    private String accountCloseFlag;

    @JsonProperty("AccountFreezeStatus")
    private String accountFreezeStatus;
}