package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrNetLoanDetails {

    @JsonProperty("AccountId")
    private String accountId;

    @JsonProperty("SchemeCode")
    private String schemeCode;

    @JsonProperty("SchemeType")
    private String schemeType;

    @JsonProperty("BranchCode")
    private String branchCode;

    @JsonProperty("AccountBalance")
    private String accountBalance;

    @JsonProperty("LoanAmount")
    private String loanAmount;

    @JsonProperty("DisburseAmount")
    private String disburseAmount;

    @JsonProperty("InstallmentAmount")
    private String installmentAmount;

    @JsonProperty("NextInstallmentDate")
    private String nextInstallmentDate;

    @JsonProperty("accountDtls")
    private AccountDtls accountDtls;

    @JsonProperty("loanDtls")
    private LoanDtls loanDtls;

    @JsonProperty("rescheduleDtls")
    private RescheduleDtls rescheduleDtls;

    @JsonProperty("paymentDtls")
    private PaymentDtls paymentDtls;

    @JsonProperty("jointHolderDtls")
    private List<JointHolderDtls> jointHolderDtls;

    @JsonProperty("ClientDemiseDetails")
    private List<ClientDemiseDetails> clientDemiseDetails;

    @JsonProperty("JointHolderDemiseDetails")
    private List<JointHolderDemiseDetails> jointHolderDemiseDetails;
}
