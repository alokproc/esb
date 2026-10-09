package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Party {

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Age")
    private String age;

    @JsonProperty("Relationship")
    private String relationship;

    @JsonProperty("GuardianName")
    private String guardianName;

    @JsonProperty("MinorStatus")
    private String minorStatus;

    @JsonProperty("Address")
    private Address address;
}
