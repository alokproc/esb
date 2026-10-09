package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {

    @JsonProperty("StreetName")
    private String streetName;

    @JsonProperty("BuildingNumber")
    private String buildingNumber;

    @JsonProperty("Department")
    private String department;

    @JsonProperty("SubDepartment")
    private String subDepartment;
}

