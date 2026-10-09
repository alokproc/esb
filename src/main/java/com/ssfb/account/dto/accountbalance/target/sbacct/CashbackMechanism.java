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
public class CashbackMechanism {
    @XmlElement(name = "FIRSTCREDITFLG", namespace = "http://www.finacle.com/fixml")
    private String firstCreditFlg;

    @XmlElement(name = "MOBILENO", namespace = "http://www.finacle.com/fixml")
    private String mobileNo;
}
