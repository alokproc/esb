package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class NomineeInfoRec {
    @XmlElement(name = "RegNum", namespace = "http://www.finacle.com/fixml")
    private String regNum;

    @XmlElement(name = "NomineeName", namespace = "http://www.finacle.com/fixml")
    private String nomineeName;

    @XmlElement(name = "RelType", namespace = "http://www.finacle.com/fixml")
    private String relType;

    @XmlElement(name = "NomineeContactInfo", namespace = "http://www.finacle.com/fixml")
    private NomineeContactInfo nomineeContactInfo;

    @XmlElement(name = "NomineeMinorFlg", namespace = "http://www.finacle.com/fixml")
    private String nomineeMinorFlg;

    @XmlElement(name = "NomineeBirthDt", namespace = "http://www.finacle.com/fixml")
    private String nomineeBirthDt;

    @XmlElement(name = "NomineePercent", namespace = "http://www.finacle.com/fixml")
    private NomineePercent nomineePercent;

    @XmlElement(name = "GuardianInfo", namespace = "http://www.finacle.com/fixml")
    private GuardianInfo guardianInfo;
}
