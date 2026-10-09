package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDet {

    @JsonProperty("CIFNUMBER")
    private String cifNumber;

    @JsonProperty("ADDRESSTYPE")
    private String addressType;

    @JsonProperty("ADDRESS1")
    private String address1;

    @JsonProperty("ADDRESS2")
    private String address2;

    @JsonProperty("ADDRESS3")
    private String address3;

    @JsonProperty("ADDRESS4")
    private String address4;

    @JsonProperty("LANDMARK")
    private String landmark;

    @JsonProperty("PINCODE")
    private String pincode;

    @JsonProperty("CITY")
    private String city;

    @JsonProperty("STATE")
    private String state;

    @JsonProperty("COUNTRY")
    private String country;

    @JsonProperty("MOBILE")
    private String mobile;

    @JsonProperty("EMAILID")
    private String emailId;
}
