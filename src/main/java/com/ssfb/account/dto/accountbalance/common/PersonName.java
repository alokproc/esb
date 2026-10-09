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
public class PersonName {
    @XmlElement(name = "LastName", namespace = "http://www.finacle.com/fixml")
    private String lastName;

    @XmlElement(name = "FirstName", namespace = "http://www.finacle.com/fixml")
    private String firstName;

    @XmlElement(name = "MiddleName", namespace = "http://www.finacle.com/fixml")
    private String middleName;

    @XmlElement(name = "Name", namespace = "http://www.finacle.com/fixml")
    private String name;

    @XmlElement(name = "TitlePrefix", namespace = "http://www.finacle.com/fixml")
    private String titlePrefix;
}
