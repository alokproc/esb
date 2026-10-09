package com.ssfb.account.dto.opendigitdrd.source;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TDRDCreateRequestBody {

    @JsonProperty("Product")
    private Product product;

    @JsonProperty("Amount")
    private Amount amount;

    @Size(min = 0, max = 20, message = "AccountId length must be between 0 and 20")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid AccountId")
    @JsonProperty("AccountId")
    private String accountId;

    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid modeOfOperation")
    @JsonProperty("ModeOfOperation")
    private String modeOfOperation;

    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid DepositFrequency")
    @JsonProperty("DepositFrequency")
    private String depositFrequency;

    @JsonProperty("Maturity")
    private Maturity maturity;

    @JsonProperty("TransferAccount")
    private TransferAccount transferAccount;

    @Size(min = 0, max = 6, message = "BranchId length must be between 0 and 6")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid BranchId")
    @JsonProperty("BranchId")
    private String branchId;

    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid InterestDisbursementMode")
    @JsonProperty("InterestDisbursementMode")
    private String interestDisbursementMode;

    @JsonProperty("InterestTransferAccount")
    private InterestTransferAccount interestTransferAccount;

    @Pattern(regexp = "^([a-zA-Z0-9][\\s]*)*$", message = "Invalid RecurringDepositFrequency")
    @JsonProperty("RecurringDepositFrequency")
    private String recurringDepositFrequency;

    @Pattern(regexp = "^([a-zA-Z0-9][\\s]*)*$", message = "Invalid Comments")
    @JsonProperty("Comments")
    private String comments;

    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid ReferenceNo")
    @JsonProperty("ReferenceNo")
    private String referenceNo;

    @Size(min = 0, max = 9, message = "CustomerId length must be between 0 and 9")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid CustomerId")
    @JsonProperty("CustomerId")
    private String customerId;

    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid AutoDebitFrequency")
    @JsonProperty("AutoDebitFrequency")
    private String autoDebitFrequency;

    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid AutoDebitDay")
    @JsonProperty("AutoDebitDay")
    private String autoDebitDay;

    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid ReferenceId")
    @JsonProperty("ReferenceId")
    private String referenceId;

    @Valid
    @JsonProperty("Party")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @NotEmpty
    @Size(min = 1, max = 4)
    private List<Party> party;


    @JsonProperty("Agent")
    private Agent agent;

    @Valid
    @JsonProperty("RelParty")
    private List<RelParty> relParty;

    @Valid
    @JsonProperty("PostalAddress")
    private PostalAddress postalAddress;

    @Valid
    @JsonProperty("Beneficiary")
    private Beneficiary beneficiary;

    @JsonProperty("BCUserId")
    private String bCUserId;

    @Pattern(regexp = "^\\w*$", message = "Invalid LeadGenerator")
    @JsonProperty("LeadGenerator")
    private String leadGenerator;

    @Pattern(regexp = "^(\\d[\\d-]*)*$", message = "Invalid AccountOpenDate")
    @JsonProperty("AccountOpenDate")
    private String accountOpenDate;

    @JsonProperty("ScopeFlag")
    private String scopeFlag;

    @JsonProperty("JointAcctHldrInfo")
    private String jointAcctHldrInfo;

    @Pattern(regexp = "^\\w*$", message = "Invalid AccountRelationship")
    @JsonProperty("AccountRelationship")
    private String accountRelationship;

    @JsonProperty("AccountType")
    private String accountType;

    @JsonProperty("NomineeType")
    private String nomineeType;

    @JsonProperty("BestRateAutoRen")
    private String bestRateAutoRen;

    @JsonProperty("PhoneNumber")
    private String phoneNumber;

    @JsonProperty("EmailId")
    private String emailId;

    @JsonProperty("PlanCode")
    private String planCode;

    @JsonProperty("UMRNNumber")
    private String umrnNumber;

    @JsonProperty("PaymentId")
    private String paymentId;

    @JsonProperty("RMCode")
    private String rmCode;

    @JsonProperty("LCCode")
    private String lcCode;

    @JsonProperty("LGCode")
    private String lgCode;












}
