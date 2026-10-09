package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JointHolderDtls {

    @JsonProperty("RelPartyType")
    private String relPartyType;

    @JsonProperty("RelPartyTypeDesc")
    private String relPartyTypeDesc;

    @JsonProperty("RelPartyCode")
    private String relPartyCode;

    @JsonProperty("RelPartyCodeDesc")
    private String relPartyCodeDesc;

    @JsonProperty("CustID")
    private String custId;

    @JsonProperty("CustName")
    private String custName;

    @JsonProperty("ContactInfo")
    private List<ContactInfo> contactInfo;
}
