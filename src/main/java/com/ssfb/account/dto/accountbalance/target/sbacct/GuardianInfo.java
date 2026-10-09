package com.ssfb.account.dto.accountbalance.target.sbacct;

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
public class GuardianInfo {
    @XmlElement(name = "GuardianCode", namespace = "http://www.finacle.com/fixml")
    private String guardianCode;

    @XmlElement(name = "GuardianName", namespace = "http://www.finacle.com/fixml")
    private String guardianName;

    @XmlElement(name = "GuardianContactInfo", namespace = "http://www.finacle.com/fixml")
    private GuardianContactInfo guardianContactInfo;
}
