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
public class TDAcctAddCustomData {
    @XmlElement(name = "CHANNEL_LEVEL_CODE", namespace = "http://www.finacle.com/fixml")
    private String channelLevelCode;

    @XmlElement(name = "RM_CODE", namespace = "http://www.finacle.com/fixml")
    private String rmCode;

    @XmlElement(name = "LC_CODE", namespace = "http://www.finacle.com/fixml")
    private String lcCode;

    @XmlElement(name = "LG_CODE", namespace = "http://www.finacle.com/fixml")
    private String lgCode;

    @XmlElement(name = "ACCTLABEL", namespace = "http://www.finacle.com/fixml")
    private String acctLabel;

    @XmlElement(name = "XFERIND", namespace = "http://www.finacle.com/fixml")
    private String xferInd;

    @XmlElement(name = "DEPFREQ", namespace = "http://www.finacle.com/fixml")
    private String depFreq;

    @XmlElement(name = "CRITSOLID", namespace = "http://www.finacle.com/fixml")
    private String critSolId;

    @XmlElement(name = "CHNLID", namespace = "http://www.finacle.com/fixml")
    private String chnlId;

    @XmlElement(name = "CREMODE", namespace = "http://www.finacle.com/fixml")
    private String creMode;

    @XmlElement(name = "INTCRACCT", namespace = "http://www.finacle.com/fixml")
    private String intCrAcct;

    @XmlElement(name = "MODEOFOPERATION", namespace = "http://www.finacle.com/fixml")
    private String modeOfOperation;

    @XmlElement(name = "PLAN_CODE", namespace = "http://www.finacle.com/fixml")
    private String planCode;

    @XmlElement(name = "ACCTOPNDATE", namespace = "http://www.finacle.com/fixml")
    private String acctOpnDate;

    @XmlElement(name = "OPENEFFDATE", namespace = "http://www.finacle.com/fixml")
    private String openEffDate;

    @XmlElement(name = "SCOPEFLG", namespace = "http://www.finacle.com/fixml")
    private String scopeFlg;

    @XmlElement(name = "LEADGENCODE", namespace = "http://www.finacle.com/fixml")
    private String leadGenCode;

    @XmlElement(name = "ACNRELC", namespace = "http://www.finacle.com/fixml")
    private String acnRelC;

    @XmlElement(name = "FREETEXT10", namespace = "http://www.finacle.com/fixml")
    private String freeText10;

    @XmlElement(name = "FREETEXT13", namespace = "http://www.finacle.com/fixml")
    private String freeText13;

    @XmlElement(name = "APPLICATIONREFID", namespace = "http://www.finacle.com/fixml")
    private String applicationRefId;

    @XmlElement(name = "FREETEXT1", namespace = "http://www.finacle.com/fixml")
    private String freeText1;

    @XmlElement(name = "TDMISCENTRD", namespace = "http://www.finacle.com/fixml")
    private String tdMisCentRd;

    @XmlElement(name = "TOTPMTENTD", namespace = "http://www.finacle.com/fixml")
    private String totPmtEntd;

    @XmlElement(name = "PHONE_NUM", namespace = "http://www.finacle.com/fixml")
    private String phoneNum;

    @XmlElement(name = "EMAIL_ID", namespace = "http://www.finacle.com/fixml")
    private String emailId;

    @XmlElement(name = "NOMINEE_TYPE", namespace = "http://www.finacle.com/fixml")
    private String nomineeType;

    @XmlElement(name = "TOPMTSYS", namespace = "http://www.finacle.com/fixml")
    private TOPMTSYS topmtsys;

    @XmlElement(name = "POPMTENTD", namespace = "http://www.finacle.com/fixml")
    private String popmtEntd;

    @XmlElement(name = "POPMTSYS", namespace = "http://www.finacle.com/fixml")
    private POPMTSYS popmtsys;

    @XmlElement(name = "IOPMTENTD", namespace = "http://www.finacle.com/fixml")
    private String iopmtEntd;

    @XmlElement(name = "IOPMTSYS", namespace = "http://www.finacle.com/fixml")
    private IOPMTSYS iopmtsys;

    @XmlElement(name = "RELPARTY", namespace = "http://www.finacle.com/fixml")
    private List<RelPartyTarget> relPartyTarget;

    @XmlElement(name = "DOC", namespace = "http://www.finacle.com/fixml")
    private Doc doc;

    //Response tags target

    @XmlElement(name = "CRITSOLID", namespace = "http://www.finacle.com/fixml")
    private String critSOLID;

    @XmlElement(name = "PLAN_CODE", namespace = "http://www.finacle.com/fixml")
    private String planCODE;

    @XmlElement(name = "PLAN_ID", namespace = "http://www.finacle.com/fixml")
    private String plan_ID;

}
