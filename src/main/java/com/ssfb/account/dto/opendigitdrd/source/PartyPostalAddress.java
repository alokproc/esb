package com.ssfb.account.dto.opendigitdrd.source;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PartyPostalAddress {

    @JsonProperty("BuildingNumber")
    private String buildingNumber;

    @JsonProperty("StreetName")
    private String streetName;

    @JsonProperty("Department")
    private String department;

    @JsonProperty("AddressLine")
    private String addressLine;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("Accept")
    private String accept;

    @JsonProperty("City")
    private String city;

    @JsonProperty("State")
    private String state;

    @JsonProperty("PostalCode")
    private String postalCode;

    @JsonProperty("Country")
    private String country;
}
