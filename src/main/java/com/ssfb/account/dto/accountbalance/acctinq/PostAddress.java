package com.ssfb.account.dto.accountbalance.acctinq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostAddress {
    @JsonProperty(value = "Address1")
    private String addr1;

    @JsonProperty(value = "Address2")
    private String addr2;

    @JsonProperty(value = "Address3")
    private String addr3;

    @JsonProperty(value = "City")
    private String city;

    @JsonProperty(value = "StateProv")
    private String stateProv;

    @JsonProperty(value = "PostalCode")
    private String postalCode;

    @JsonProperty(value = "Country")
    private String country;

    @JsonProperty(value = "AddressType")
    private String addrType;
}
