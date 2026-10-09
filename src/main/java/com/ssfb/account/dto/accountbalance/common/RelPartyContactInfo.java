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
public class RelPartyContactInfo {
    @XmlElement(name = "PhoneNum", namespace = "http://www.finacle.com/fixml")
    private PhoneNum phoneNum;

    @XmlElement(name = "EmailAddr", namespace = "http://www.finacle.com/fixml")
    private String emailAddr;

    @XmlElement(name = "PostAddr", namespace = "http://www.finacle.com/fixml")
    private PostAddr postAddr;
}
