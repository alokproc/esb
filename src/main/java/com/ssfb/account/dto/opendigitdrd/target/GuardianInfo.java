package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class GuardianInfo {
    @XmlElement(name = "GuardianCode", namespace = "http://www.finacle.com/fixml")
    private String guardianCode;

    @XmlElement(name = "GuardianName", namespace = "http://www.finacle.com/fixml")
    private String guardianName;

    @XmlElement(name = "GuardianContactInfo", namespace = "http://www.finacle.com/fixml")
    private GuardianContactInfo guardianContactInfo;
}
