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
public class PhoneNum {
    @XmlElement(name = "TelephoneNum", namespace = "http://www.finacle.com/fixml")
    private String telephoneNum;

    @XmlElement(name = "FaxNum", namespace = "http://www.finacle.com/fixml")
    private String faxNum;

    @XmlElement(name = "TelexNum", namespace = "http://www.finacle.com/fixml")
    private String telexNum;
}
