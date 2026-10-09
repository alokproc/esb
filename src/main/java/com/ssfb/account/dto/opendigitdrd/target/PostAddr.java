package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
