package com.ssfb.account.dto.opendigitdrd.source;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PostalAddress {

    @JsonProperty("BuildingNumber")
    private String buildingNumber;

    @JsonProperty("StreetName")
    private String streetName;

    @JsonProperty("Department")
    private String department;

    @JsonProperty("AddressLine")
    private String addressLine;

    @JsonProperty("Age")
    private String age;

    @JsonProperty("Relationship")
    private String relationship;

    @JsonProperty("NickName")
    private String nickName;

    @JsonProperty("Minor")
    private String minor;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("Accept")
    private String accept;

    @JsonProperty("GuardianName")
    private String guardianName;

    @JsonProperty("City")
    private String city;

    @JsonProperty("State")
    private String state;

    @JsonProperty("PostalCode")
    private String postalCode;

    @JsonProperty("Country")
    private String country;
}

