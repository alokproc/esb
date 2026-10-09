package com.ssfb.account.dto.accountbalance.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class PostAddr {
    @XmlElement(name = "Addr1", namespace = "http://www.finacle.com/fixml")
    private String addr1;

    @XmlElement(name = "Addr2", namespace = "http://www.finacle.com/fixml")
    private String addr2;

    @XmlElement(name = "Addr3", namespace = "http://www.finacle.com/fixml")
    private String addr3;

    @XmlElement(name = "City", namespace = "http://www.finacle.com/fixml")
    private String city;

    @XmlElement(name = "StateProv", namespace = "http://www.finacle.com/fixml")
    private String stateProv;

    @XmlElement(name = "PostalCode", namespace = "http://www.finacle.com/fixml")
    private String postalCode;

    @XmlElement(name = "Country", namespace = "http://www.finacle.com/fixml")
    private String country;

    @XmlElement(name = "AddrType", namespace = "http://www.finacle.com/fixml")
    private String addrType;
}
