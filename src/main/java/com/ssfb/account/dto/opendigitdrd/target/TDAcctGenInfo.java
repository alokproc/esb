package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class TDAcctGenInfo {
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

    @XmlElement(name = "DespatchMode", namespace = "http://www.finacle.com/fixml")
    private String despatchMode;
}
