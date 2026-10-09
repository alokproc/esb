package com.ssfb.account.dto.opendigitdrd.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Party {

    @Pattern(
            regexp = "^[a-zA-Z0-9]*$",
            message = "Invalid Party Type"
    )
    @JsonProperty("Type")
    private String type;

    @Pattern(
            regexp = "^([a-zA-Z0-9][\\s]*)*$",
            message = "Invalid Party Name"
    )
    @JsonProperty("Name")
    private String name;

    @Pattern(
            regexp = "^(\\d[\\d-]*)*$",
            message = "Invalid DateOfBirth"
    )
    @JsonProperty("DateOfBirth")
    private String dateOfBirth;

    @JsonProperty("MobileNumber")
    private String mobileNumber;

    @JsonProperty("EmailId")
    private String emailId;

    @JsonProperty("Relationship")
    private String relationship;

    @JsonProperty("Minor")
    private String minor;

    @JsonProperty("Age")
    private String age;

    @JsonProperty("NomineePercent")
    private String nomineePercent;

    @JsonProperty("PostalAddress")
    private PartyPostalAddress partyPostalAddress;

    @Valid
    @JsonProperty("Guardian")
    private Guardian guardian;

}
