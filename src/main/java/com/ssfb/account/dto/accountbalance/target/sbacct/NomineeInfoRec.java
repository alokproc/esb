package com.ssfb.account.dto.accountbalance.target.sbacct;

import com.ssfb.account.dto.accountbalance.common.InterestRate;
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

    @XmlElement(name = "NomineePercent", namespace = "http://www.finacle.com/fixml")
    private InterestRate nomineePercent;

    @XmlElement(name = "GuardianInfo", namespace = "http://www.finacle.com/fixml")
    private GuardianInfo guardianInfo;

    @XmlElement(name = "RecDelFlg", namespace = "http://www.finacle.com/fixml")
    private String recDelFlg;
}
