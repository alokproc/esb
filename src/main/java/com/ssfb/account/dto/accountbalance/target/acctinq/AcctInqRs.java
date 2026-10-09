package com.ssfb.account.dto.accountbalance.target.acctinq;

import com.ssfb.account.dto.accountbalance.common.AcctId;
import com.ssfb.account.dto.accountbalance.common.CustId;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class AcctInqRs {
    @XmlElement(name = "AcctId", namespace = "http://www.finacle.com/fixml")
    private AcctId acctId;

    @XmlElement(name = "CustId", namespace = "http://www.finacle.com/fixml")
    private CustId custId;

    @XmlElement(name = "AcctOpenDt", namespace = "http://www.finacle.com/fixml")
    private String acctOpenDt;

    @XmlElement(name = "BankAcctStatusCode", namespace = "http://www.finacle.com/fixml")
    private String bankAcctStatusCode;

    @XmlElement(name = "AcctBal", namespace = "http://www.finacle.com/fixml")
    private List<AcctBal> acctBal;

    @XmlElement(name = "CustStat", namespace = "http://www.finacle.com/fixml")
    private List<CustStat> custStat;

    @XmlElement(name = "AcctCloseFlag", namespace = "http://www.finacle.com/fixml")
    private String acctCloseFlag;
}
