package com.ssfb.account.dto.opendigitdrd.tdrddetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssfb.account.dto.helper.PostalAddress2;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    @JsonProperty("DateOfBirth")
    private String dateOfBirth;
    @JsonProperty("Relationship")
    private String relationship;
    @JsonProperty("NickName")
    private String nickName;
    @JsonProperty("GuardianName")
    private String guardianName;
    @JsonProperty("MinorStatus")
    private String minorStatus;
    @JsonProperty("Address")
    private PostalAddress2 address;


}
