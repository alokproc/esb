package com.ssfb.account.dto.accountbalance.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountBalanceSourceResponseBody {
    @JsonProperty("TransactionCode")
    private String transactionCode;

    @JsonProperty("AccountRestriction")
    private String accountRestriction;

    @JsonProperty("AccuredInterest")
    private String accuredInterest;

    @JsonProperty("ClearningAllowedOnProduct")
    private String clearningAllowedOnProduct;

    @JsonProperty("MICR")
    private String micr;

    @JsonProperty("RDInstallmentNumber")
    private String rdInstallmentNumber;

    @JsonProperty("RDInstallmentNextDate")
    private String rdInstallmentNextDate;

    @JsonProperty("RestrictionCode")
    private String restrictionCode;

    @JsonProperty("RestrictionDescription")
    private String restrictionDescription;

    @JsonProperty("CustomerId")
    private String customerId;

    @JsonProperty("AccountRelationship")
    private String accountRelationship;

    @JsonProperty("AccountId")
    private String accountId;

    @JsonProperty("NickName")
    private String nickName;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("BranchId")
    private String branchId;

    @JsonProperty("EmailAddress")
    private String emailAddress;

    @JsonProperty("Product")
    private Product product;

    @JsonProperty("CreationDateTime")
    private String creationDateTime;

    @JsonProperty("ChequeBookRequested")
    private String chequeBookRequested;

    @JsonProperty("ModeOfOperation")
    private String modeOfOperation;

    @JsonProperty("ModeOfOperationDescription")
    private String modeOfOperationDescription;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("MinBalance")
    private String minBalance;

    @JsonProperty("Interest")
    private String interest;

    @JsonProperty("PostalAddress")
    private String postalAddress;

    @JsonProperty("NRENRO")
    private String nreNro;

    @JsonProperty("Balance")
    private List<Balance> balance;

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

    @JsonProperty("RelParty")
    private List<Relparty> relParty;
}
