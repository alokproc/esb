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
public class BeneficiaryDet {
    @XmlElement(name = "BEN_ACCT_ID", namespace = "http://www.finacle.com/fixml")
    private String benAcctId;

    @XmlElement(name = "BEN_NAME", namespace = "http://www.finacle.com/fixml")
    private String benName;

    @XmlElement(name = "BEN_IFSC", namespace = "http://www.finacle.com/fixml")
    private String benIfsc;
}
