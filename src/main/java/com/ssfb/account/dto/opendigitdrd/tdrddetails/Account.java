package com.ssfb.account.dto.opendigitdrd.tdrddetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssfb.account.dto.helper.PostalAddress2;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
    public  class Account {

        @JsonProperty("AccountId")
        private String accountId;

        @Valid
        @JsonProperty("Product")
        private Product product;

        @Valid
        @JsonProperty("Balance")
        private List<Balance> balance;

        @JsonProperty("ModeOfOperation")
        private String modeOfOperation;

        @JsonProperty("Relationship")
        private String relationship;

        @JsonProperty("CreationDate")
        private String creationDate;

        @JsonProperty("AccountCloseDate")
        private String accountCloseDate;

        @Valid
        @JsonProperty("Maturity")
        private Maturity maturity;

        @JsonProperty("BranchCode")
        private String branchCode;

        @JsonProperty("Name")
        private String name;

        @JsonProperty("InterestRate")
        private String interestRate;

        @JsonProperty("NetIntRate")
        private String netIntRate;

        @JsonProperty("DepositFrequency")
        private String depositFrequency;

        @JsonProperty("TitleLine")
        private List<String> titleLine;

        @JsonProperty("Status")
        private String status;

        @JsonProperty("AccruedInterest")
        private String accruedInterest;

        @JsonProperty("IntAvlr")
        private String intAvlr;

        @JsonProperty("IPF")
        private String ipf;

        @JsonProperty("ICF")
        private String icf;

        @JsonProperty("IAF")
        private String iaf;

        @JsonProperty("LOPT")
        private String lopt;

        @JsonProperty("Comments")
        private String comments;

        @JsonProperty("AutoDebitDay")
        private String autoDebitDay;

        @Valid
        @JsonProperty("Party")
        private Party party;

        @JsonProperty("ODLimit")
        private String odLimit;

        @JsonProperty("ODStartDate")
        private String odStartDate;

        @JsonProperty("ODExpiry")
        private String odExpiry;

        @JsonProperty("ODTerm")
        private String odTerm;

        @JsonProperty("TDSExemptionReason")
        private String tdsExemptionReason;

        @JsonProperty("TDSFORM")
        private String tdsForm;

        @JsonProperty("DrawingPower")
        private String drawingPower;

        @JsonProperty("DrawingPowerIndices")
        private String drawingPowerIndices;

        @JsonProperty("NetInterestRate")
        private String netInterestRate;

        @JsonProperty("SanctionLimit")
        private String sanctionLimit;

        @JsonProperty("SanctionDate")
        private String sanctionDate;

        @JsonProperty("SanctionExpiryDate")
        private String sanctionExpiryDate;

        @JsonProperty("BestRateAutoRen")
        private String bestRateAutoRen;

        @Valid
        @JsonProperty("RelParty")
        private List<RelParty> relParty;

        @Valid
        @JsonProperty("CustomerMaturityDetails")
        private CustomerMaturityDetails customerMaturityDetails;

        @JsonProperty("CustomerName")
        private String customerName;

        @Valid
        @JsonProperty("CustomerDepositDetails")
        private List<CustomerDepositDetail> customerDepositDetails;

        @Valid
        @JsonProperty("Beneficiary")
        private List<Beneficiary> beneficiary;
    }
