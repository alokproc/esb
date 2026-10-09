package com.ssfb.account.dto.accountbalance.target.sbacct;

import com.ssfb.account.dto.accountbalance.common.*;
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
public class SBAcctInqRs {
    @XmlElement(name = "SBAcctId", namespace = "http://www.finacle.com/fixml")
    private AcctId sbAcctId;

    @XmlElement(name = "AcctOpnDt", namespace = "http://www.finacle.com/fixml")
    private String acctOpnDt;

    @XmlElement(name = "ModeOfOper", namespace = "http://www.finacle.com/fixml")
    private String modeOfOper;

    @XmlElement(name = "CustId", namespace = "http://www.finacle.com/fixml")
    private CustId custId;

    @XmlElement(name = "SBAcctGenInfo", namespace = "http://www.finacle.com/fixml")
    private AcctGenInfo sbAcctGenInfo;

    @XmlElement(name = "BankAcctStatusCode", namespace = "http://www.finacle.com/fixml")
    private String bankAcctStatusCode;

    @XmlElement(name = "AcctBalCrDrInd", namespace = "http://www.finacle.com/fixml")
    private String acctBalCrDrInd;

    @XmlElement(name = "AcctBalAmt", namespace = "http://www.finacle.com/fixml")
    private AcctBalAmt acctBalAmt;

    @XmlElement(name = "AccrIntRate", namespace = "http://www.finacle.com/fixml")
    private InterestRate accrIntRate;

    @XmlElement(name = "IntCalcFreq", namespace = "http://www.finacle.com/fixml")
    private IntCalcFreq intCalcFreq;

    @XmlElement(name = "IntRateCode", namespace = "http://www.finacle.com/fixml")
    private String intRateCode;

    @XmlElement(name = "NetIntDrCrInd", namespace = "http://www.finacle.com/fixml")
    private String netIntDrCrInd;

    @XmlElement(name = "NetIntRate", namespace = "http://www.finacle.com/fixml")
    private InterestRate netIntRate;

    @XmlElement(name = "WithHoldingTaxDtls", namespace = "http://www.finacle.com/fixml")
    private WithHoldingTaxDtls withHoldingTaxDtls;

    @XmlElement(name = "NomineeInfoRec", namespace = "http://www.finacle.com/fixml")
    private NomineeInfoRec nomineeInfoRec;

    @XmlElement(name = "RelPartyRec", namespace = "http://www.finacle.com/fixml")
    private List<RelPartyRec> relPartyRec;

    @XmlElement(name = "AllowNegCrInt", namespace = "http://www.finacle.com/fixml")
    private String allowNegCrInt;
}
