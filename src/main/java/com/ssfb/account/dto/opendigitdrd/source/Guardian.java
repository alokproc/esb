package com.ssfb.account.dto.opendigitdrd.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Guardian {



        @Pattern(regexp = "^([a-zA-Z0-9][\\s]*)*$", message = "Invalid Guardian Name")
        @JsonProperty("Name")
        private String name;

        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid Guardian Code")
        @JsonProperty("Code")
        private String code;

        @JsonProperty("MobileNumber")
        private String mobileNumber;

        @JsonProperty("EmailId")
        private String emailId;

        @Pattern(
                regexp = "^([a-zA-Z0-9][a-zA-Z0-9\\w\\s/#\\-:,\\.]*)*$",
                message = "Invalid AddressLine1"
        )
        @JsonProperty("AddressLine1")
        private String addressLine1;

        @Pattern(
                regexp = "^([a-zA-Z0-9][a-zA-Z0-9\\w\\s/#\\-:,\\.]*)*$",
                message = "Invalid AddressLine2"
        )
        @JsonProperty("AddressLine2")
        private String addressLine2;

        @Pattern(
                regexp = "^([a-zA-Z0-9][a-zA-Z0-9\\w\\s/#\\-:,\\.]*)*$",
                message = "Invalid AddressLine3"
        )
        @JsonProperty("AddressLine3")
        private String addressLine3;

        @Pattern(regexp = "^([a-zA-Z0-9][\\s]*)*$", message = "Invalid City")
        @JsonProperty("City")
        private String city;

        @Pattern(regexp = "^([a-zA-Z0-9][\\s]*)*$", message = "Invalid State")
        @JsonProperty("State")
        private String state;

        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid PostalCode")
        @JsonProperty("PostalCode")
        private String postalCode;

        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid Country")
        @JsonProperty("Country")
        private String country;
    }
