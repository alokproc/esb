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
public class ProfileLoanDetails {

    @JsonProperty("AccountId")
    private String accountId;

    @JsonProperty("ProductType")
    private String productType;

    @JsonProperty("ProductGroup")
    private String productGroup;

    @JsonProperty("GrandTotalDue")
    private String grandTotalDue;

    @JsonProperty("Boo")
    private String boo;

    @JsonProperty("BranchDescription")
    private String branchDescription;

    @JsonProperty("LoanAmount")
    private String loanAmount;

    @JsonProperty("DisbursedAmount")
    private String disbursedAmount;

    @JsonProperty("NextEMIDate")
    private String nextEmiDate;

    @JsonProperty("AccountName")
    private String accountName;

    @JsonProperty("AccruedInterest")
    private String accruedInterest;

    @JsonProperty("AvailableBalance")
    private String availableBalance;

    @JsonProperty("Balance")
    private String balance;

    @JsonProperty("BranchCode")
    private String branchCode;

    @JsonProperty("CreditLimit")
    private String creditLimit;

    @JsonProperty("CurrencyCode")
    private String currencyCode;

    @JsonProperty("Days_Delinquent")
    private String daysDelinquent;

    @JsonProperty("GrandTotal")
    private String grandTotal;

    @JsonProperty("InterestRate")
    private String interestRate;

    @JsonProperty("LoanSanctionAmount")
    private String loanSanctionAmount;

    @JsonProperty("LoanSanctionDate")
    private String loanSanctionDate;

    @JsonProperty("MaturityDate")
    private String maturityDate;

    @JsonProperty("OpeningDate")
    private String openingDate;

    @JsonProperty("OperateMode")
    private String operateMode;

    @JsonProperty("OverDue")
    private String overDue;

    @JsonProperty("PrincipalInterestPayment")
    private String principalInterestPayment;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("Term")
    private String term;

    @JsonProperty("Title1")
    private String title1;

    @JsonProperty("Title2")
    private String title2;

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

