package com.ssfb.account.dto.helper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostalAddress2 {
    @JsonProperty("Type")
    @Size(max = 40)
    private String type;

    @JsonProperty("StreetName")
    private String streetName;

    @JsonProperty("BuildingNumber")
    private String buildingNumber;

    @JsonProperty("Department")
    @Size(max = 40)
    private String department;

    @JsonProperty("SubDepartment")
    private String subDepartment;

    @JsonProperty("TownName")
    private String townName;

    @JsonProperty("City")
    @Size(max = 35)
    private String city;

    @JsonProperty("Landmark")
    private String landmark;

    @JsonProperty("CountrySubDivision")
    @Size(max = 35)
    private String countrySubDivision;

    @JsonProperty("Country")
    @Size(max = 40)
    private String country;

    @JsonProperty("PostCode")
    @Size(max = 16)
    private String postCode;

    @JsonProperty("AddressLine")
    @Size(max = 160)
    private String addressLine;

    @JsonProperty("GeoLocationTp")
    private GeoLocationTp geoLocationTp;

}
