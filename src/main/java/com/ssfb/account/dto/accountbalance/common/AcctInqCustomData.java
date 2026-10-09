package com.ssfb.account.dto.accountbalance.common;

import com.ssfb.account.dto.accountbalance.target.sbacct.BeneficiaryDet;
import com.ssfb.account.dto.accountbalance.target.sbacct.CashbackMechanism;
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
public class AcctInqCustomData {
    @XmlElement(name = "ACCTLIMITSENTERED", namespace = "http://www.finacle.com/fixml")
    private String acctLimitsEntered;

    @XmlElement(name = "ACCTOPNDATE", namespace = "http://www.finacle.com/fixml")
    private String acctOpenDate;

    @XmlElement(name = "ACCTSTAT", namespace = "http://www.finacle.com/fixml")
    private String acctStat;

    @XmlElement(name = "RELPARTY", namespace = "http://www.finacle.com/fixml")
    private RelParty relParty;

    @XmlElement(name = "CHQALLWDFLG", namespace = "http://www.finacle.com/fixml")
    private String chqAllwdFlg;

    @XmlElement(name = "DRBALAMT", namespace = "http://www.finacle.com/fixml")
    private String drBalAmt;

    @XmlElement(name = "INTCRACCTFLG", namespace = "http://www.finacle.com/fixml")
    private String intCrAcctFlg;

    @XmlElement(name = "DRAWINGPOWER", namespace = "http://www.finacle.com/fixml")
    private String drawingPower;

    @XmlElement(name = "DRAWINGPOWERIND", namespace = "http://www.finacle.com/fixml")
    private String drawingPowerInd;

    @XmlElement(name = "NETINTRATE", namespace = "http://www.finacle.com/fixml")
    private String netIntRate;

    @XmlElement(name = "SANCLIMIT", namespace = "http://www.finacle.com/fixml")
    private String sanctLimit;

    @XmlElement(name = "SANCTDATE", namespace = "http://www.finacle.com/fixml")
    private String sanctDate;

    @XmlElement(name = "SCHMCODE", namespace = "http://www.finacle.com/fixml")
    private String schmCode;

    @XmlElement(name = "SCHMCODEDESC", namespace = "http://www.finacle.com/fixml")
    private String schmCodeDesc;

    @XmlElement(name = "EXPIRYDATE", namespace = "http://www.finacle.com/fixml")
    private String expiryDate;

    @XmlElement(name = "SOLID", namespace = "http://www.finacle.com/fixml")
    private String solid;

    @XmlElement(name = "WTAX", namespace = "http://www.finacle.com/fixml")
    private String wtax;

    @XmlElement(name = "AVAILDRCRFLG", namespace = "http://www.finacle.com/fixml")
    private String availDrCrFlg;

    @XmlElement(name = "EFFBALDRCRFLG", namespace = "http://www.finacle.com/fixml")
    private String effBalDrCrFlg;

    @XmlElement(name = "LEDGERDRCRFLG", namespace = "http://www.finacle.com/fixml")
    private String ledgerDrCrFlg;

    @XmlElement(name = "CASHBACK_MECHANISM", namespace = "http://www.finacle.com/fixml")
    private CashbackMechanism cashbackMechanism;

    @XmlElement(name = "BENEFICIARY_DET", namespace = "http://www.finacle.com/fixml")
    private BeneficiaryDet beneficiaryDet;
}
