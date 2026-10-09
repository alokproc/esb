package com.ssfb.account.dto.opendigitdrd.target;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)

public class TOPMTSYS {

    @XmlElement(name = "SRLNUM", namespace = "http://www.finacle.com/fixml")
    private String srlNum;

    @XmlElement(name = "AMTIND", namespace = "http://www.finacle.com/fixml")
    private String amtInd;

    @XmlElement(name = "PERCENTAGE", namespace = "http://www.finacle.com/fixml")
    private String percentage;

    @XmlElement(name = "ADDNLENTD", namespace = "http://www.finacle.com/fixml")
    private String addnlEntd;

    @XmlElement(name = "REMITMODE", namespace = "http://www.finacle.com/fixml")
    private String remitMode;

    @XmlElement(name = "PAYSYSID", namespace = "http://www.finacle.com/fixml")
    private String paySysId;

    @XmlElement(name = "REMITTERNAME", namespace = "http://www.finacle.com/fixml")
    private String remitterName;

    @XmlElement(name = "REMITTERADDR1", namespace = "http://www.finacle.com/fixml")
    private String remitterAddr1;

    @XmlElement(name = "PURPOSECODE", namespace = "http://www.finacle.com/fixml")
    private String purposeCode;

    @XmlElement(name = "BENEFNAME", namespace = "http://www.finacle.com/fixml")
    private String benefName;

    @XmlElement(name = "BENEFADDR1", namespace = "http://www.finacle.com/fixml")
    private String benefAddr1;

    @XmlElement(name = "BENEFACCT", namespace = "http://www.finacle.com/fixml")
    private String benefAcct;

    @XmlElement(name = "COLLCHRG", namespace = "http://www.finacle.com/fixml")
    private String collChrg;

    @XmlElement(name = "DEBITACCT", namespace = "http://www.finacle.com/fixml")
    private String debitAcct;

    @XmlElement(name = "CRNCYCODE", namespace = "http://www.finacle.com/fixml")
    private String crncyCode;

    @XmlElement(name = "DEPTCODE", namespace = "http://www.finacle.com/fixml")
    private String deptCode;

    @XmlElement(name = "REMITCITY", namespace = "http://www.finacle.com/fixml")
    private String remitCity;

    @XmlElement(name = "REMITSTATE", namespace = "http://www.finacle.com/fixml")
    private String remitState;

    @XmlElement(name = "REMITCOUNTRY", namespace = "http://www.finacle.com/fixml")
    private String remitCountry;

    @XmlElement(name = "REMITPINCODE", namespace = "http://www.finacle.com/fixml")
    private String remitPinCode;

    @XmlElement(name = "BENEFIFSC", namespace = "http://www.finacle.com/fixml")
    private String benefIfsc;

    @XmlElement(name = "BENEFCITY", namespace = "http://www.finacle.com/fixml")
    private String benefCity;

    @XmlElement(name = "BENEFSTATE", namespace = "http://www.finacle.com/fixml")
    private String benefState;

    @XmlElement(name = "BENEFPINCODE", namespace = "http://www.finacle.com/fixml")
    private String benefPinCode;

    @XmlElement(name = "SENDERTORECVR", namespace = "http://www.finacle.com/fixml")
    private String senderToRecvr;

    @XmlElement(name = "RECVRACCTTYPE", namespace = "http://www.finacle.com/fixml")
    private String recvrAcctType;

    @XmlAttribute(name = "isMultiRec")
    private String isMultiRec;
}
