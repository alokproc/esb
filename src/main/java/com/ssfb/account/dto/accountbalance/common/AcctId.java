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
public class AcctId {
    @XmlElement(name = "AcctId", namespace = "http://www.finacle.com/fixml")
    private String acctId;

    @XmlElement(name = "AcctType", namespace = "http://www.finacle.com/fixml")
    private AcctType acctType;

    @XmlElement(name = "AcctCurr", namespace = "http://www.finacle.com/fixml")
    private String acctCurr;

    @XmlElement(name = "BankInfo", namespace = "http://www.finacle.com/fixml")
    private BankInfo bankInfo;
}
