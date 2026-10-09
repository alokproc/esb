package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    @JsonProperty("Type")
    private String type;

    @JsonProperty("Group")
    private String group;

    @JsonProperty("ProductClass")
    private String productClass;

    @JsonProperty("Balance")
    private String balance;

    @JsonProperty("OriginalAmount")
    private String originalAmount;

    @JsonProperty("Boo")
    private String boo;

    @JsonProperty("AvailBalance")
    private String availBalance;

    @JsonProperty("AcctName")
    private String acctName;

    @JsonProperty("NominalIntRate")
    private String nominalIntRate;

    @JsonProperty("CurrencyCode")
    private String currencyCode;

    @JsonProperty("Poi")
    private String poi;

    @JsonProperty("SchProc")
    private String schProc;

    @JsonProperty("Flexi")
    private String flexi;

    @JsonProperty("RelCode")
    private String relCode;

    @JsonProperty("OperateMode")
    private String operateMode;

    @JsonProperty("Pan")
    private String pan;

    @JsonProperty("PanNumber")
    private String panNumber;

    @JsonProperty("AccountStatus")
    private String accountStatus;

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

    @JsonProperty("AccountOpenDate")
    private String accountOpenDate;

    @JsonProperty("AccountCloseDate")
    private String accountCloseDate;

    @JsonProperty("AccountCloseFlag")
    private String accountCloseFlag;

    @JsonProperty("AccountFreezeStatus")
    private String accountFreezeStatus;

}
