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
public class AcctGenInfo {
    @XmlElement(name = "EotEnabled", namespace = "http://www.finacle.com/fixml")
    private String eotEnabled;

    @XmlElement(name = "DrIntMethodInd", namespace = "http://www.finacle.com/fixml")
    private String drIntMethodInd;

    @XmlElement(name = "GenLedgerSubHead", namespace = "http://www.finacle.com/fixml")
    private GenLedgerSubHead genLedgerSubHead;

    @XmlElement(name = "AcctName", namespace = "http://www.finacle.com/fixml")
    private String acctName;

    @XmlElement(name = "AcctShortName", namespace = "http://www.finacle.com/fixml")
    private String acctShortName;

    @XmlElement(name = "AcctStmtMode", namespace = "http://www.finacle.com/fixml")
    private String acctStmtMode;

    @XmlElement(name = "AcctStmtFreq", namespace = "http://www.finacle.com/fixml")
    private AcctStmtFreq acctStmtFreq;

    @XmlElement(name = "AcctStmtNxtPrintDt", namespace = "http://www.finacle.com/fixml")
    private String acctStmtNxtPrintDt;

    @XmlElement(name = "DespatchMode", namespace = "http://www.finacle.com/fixml")
    private String despatchMode;
}
