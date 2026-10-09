package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class TDAcctAddRq {
    @XmlElement(name = "CustId", namespace = "http://www.finacle.com/fixml")
    private CustId custId;

    @XmlElement(name = "TDAcctId", namespace = "http://www.finacle.com/fixml")
    private TDAcctId tdAcctId;

    @XmlElement(name = "TDAcctGenInfo", namespace = "http://www.finacle.com/fixml")
    private TDAcctGenInfo tdAcctGenInfo;

    @XmlElement(name = "InitialDeposit", namespace = "http://www.finacle.com/fixml")
    private InitialDeposit initialDeposit;

    @XmlElement(name = "DepositTerm", namespace = "http://www.finacle.com/fixml")
    private DepositTerm depositTerm;

    @XmlElement(name = "RepayAcctId", namespace = "http://www.finacle.com/fixml")
    private RepayAcctId repayAcctId;

    @XmlElement(name = "OperAcctId", namespace = "http://www.finacle.com/fixml")
    private OperAcctId operAcctId;

    @XmlElement(name = "RenewalDtls", namespace = "http://www.finacle.com/fixml")
    private RenewalDtls renewalDtls;

    @XmlElement(name = "TrnDtls", namespace = "http://www.finacle.com/fixml")
    private TrnDtls trnDtls;

    @XmlElement(name = "NomineeInfoRec", namespace = "http://www.finacle.com/fixml")
    private List<NomineeInfoRec> nomineeInfoRec;

    @XmlElement(name = "RelPartyRec", namespace = "http://www.finacle.com/fixml")
    private List<RelPartyRec> relPartyRec;
}
