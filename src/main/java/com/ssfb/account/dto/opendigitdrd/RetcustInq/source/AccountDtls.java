package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDtls {

    @JsonProperty("BranchName")
    private String branchName;

    @JsonProperty("AccountName")
    private String accountName;

    @JsonProperty("accountOpenDt")
    private String accountOpenDt;

    @JsonProperty("acctStmtMode")
    private String acctStmtMode;

    @JsonProperty("genLedgerSubHeadCode")
    private String genLedgerSubHeadCode;

    @JsonProperty("despatchMode")
    private String despatchMode;
}
