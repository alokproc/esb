package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class RtCustInqRequestBody {
    @JsonProperty("CustomerNo")
    private String customerNo;

    @JsonProperty("MobileNo")
    private String mobileNo;

    @JsonProperty("AadhaarNo")
    private String aadhaarNo;

    @JsonProperty("AadhaarReferenceNo")
    private String aadhaarReferenceNo;

    @JsonProperty("PanNo")
    private String panNo;

    @JsonProperty("BranchCode")
    private String branchCode;

    @JsonProperty("ProductGroup")
    private String productGroup;

    @JsonProperty("AccountNo")
    private String accountNo;

    @JsonProperty("VoterId")
    private String voterId;

    @JsonProperty("DateOfBirth")
    private String dateOfBirth;

    @JsonProperty("EmailId")
    private String emailId;

}
