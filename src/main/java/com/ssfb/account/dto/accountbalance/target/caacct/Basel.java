package com.ssfb.account.dto.accountbalance.target.caacct;

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
public class Basel {
    @XmlElement(name = "security_indicator", namespace = "http://www.finacle.com/fixml")
    private InterestRate securityIndicator;

    @XmlElement(name = "debt_seniority", namespace = "http://www.finacle.com/fixml")
    private String debtSeniority;

    @XmlElement(name = "security_code", namespace = "http://www.finacle.com/fixml")
    private SecurityCode securityCode;
}
