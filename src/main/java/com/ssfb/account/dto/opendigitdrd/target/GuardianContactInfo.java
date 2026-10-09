package com.ssfb.account.dto.opendigitdrd.target;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public  class GuardianContactInfo {

    @XmlElement(name = "PhoneNum", namespace = "http://www.finacle.com/fixml")
    private PhoneNum phoneNum;

    @XmlElement(name = "EmailAddr", namespace = "http://www.finacle.com/fixml")
    private String emailAddr;

    @XmlElement(name = "PostAddr", namespace = "http://www.finacle.com/fixml")
    private PostAddr postAddr;
}
