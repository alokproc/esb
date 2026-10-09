package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanDtls {

    @JsonProperty("loanPeriodDays")
    private String loanPeriodDays;

    @JsonProperty("loanPeriodMonths")
    private String loanPeriodMonths;

    @JsonProperty("netInterestRate")
    private String netInterestRate;

    @JsonProperty("rePmtMethod")
    private String rePmtMethod;

    @JsonProperty("OperativeAcctId")
    private String operativeAcctId;

    @JsonProperty("OperativeSchemeCode")
    private String operativeSchemeCode;

    @JsonProperty("OperativeSchemeType")
    private String operativeSchemeType;

    @JsonProperty("OperativeBranchId")
    private String operativeBranchId;

    @JsonProperty("OperativeBranchName")
    private String operativeBranchName;

    @JsonProperty("amtAlreadyDisb")
    private String amtAlreadyDisb;

    @JsonProperty("amtAvailForDisb")
    private String amtAvailForDisb;

    @JsonProperty("disburseDate")
    private String disburseDate;

    @JsonProperty("sourceDealerId")
    private String sourceDealerId;

    @JsonProperty("sourceDealerName")
    private String sourceDealerName;

    @JsonProperty("disburseDealerId")
    private String disburseDealerId;

    @JsonProperty("disburseDealerName")
    private String disburseDealerName;

    @JsonProperty("LoanAccountStatus")
    private String loanAccountStatus;

    @JsonProperty("LoanOutstanding")
    private String loanOutstanding;

    @JsonProperty("EMIAmount")
    private String emiAmount;

    @JsonProperty("ClientID")
    private String clientId;

    @JsonProperty("PrincipalOutstanding")
    private String principalOutstanding;

    @JsonProperty("InterestOutstanding")
    private String interestOutstanding;

    @JsonProperty("NoOfEMIPaid")
    private String noOfEmiPaid;

    @JsonProperty("RepaymentFrequency")
    private String repaymentFrequency;

    @JsonProperty("RepaymentTerm")
    private String repaymentTerm;
}
