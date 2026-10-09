package com.ssfb.account.dto.partialrdclose.target;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class ExecuteFinacleScriptCustomData {

    @XmlElement(name = "AccountNumber", namespace = "http://www.finacle.com/fixml")
    private String accountNumber;

    @XmlElement(name = "rePayAccount", namespace = "http://www.finacle.com/fixml")
    private String rePayAccount;

    @XmlElement(name = "clrValueDate", namespace = "http://www.finacle.com/fixml")
    private String clrValueDate;

    @XmlElement(name = "rePayMode", namespace = "http://www.finacle.com/fixml")
    private String rePayMode;

    @XmlElement(name = "clsrReason", namespace = "http://www.finacle.com/fixml")
    private String clsrReason;

    @XmlElement(name = "Clousreamount", namespace = "http://www.finacle.com/fixml")
    private String clousreamount;

    //response of TUA/TD

    @XmlElement(name = "SuccessOrFailure", namespace = "http://www.finacle.com/fixml")
    private String successOrFailure;

    @XmlElement(name = "DepositAmt", namespace = "http://www.finacle.com/fixml")
    private String depositAmt;

    @XmlElement(name = "EffIntPcnt", namespace = "http://www.finacle.com/fixml")
    private String effIntPcnt;

    @XmlElement(name = "NormalIntPcnt", namespace = "http://www.finacle.com/fixml")
    private String normalIntPcnt;

    @XmlElement(name = "NetIntrestPaid", namespace = "http://www.finacle.com/fixml")
    private String netIntrestPaid;

    @XmlElement(name = "NormalIntAmt", namespace = "http://www.finacle.com/fixml")
    private String normalIntAmt;

    @XmlElement(name = "PenalIntAmt", namespace = "http://www.finacle.com/fixml")
    private String penalIntAmt;

    @XmlElement(name = "PenaltyAmount", namespace = "http://www.finacle.com/fixml")
    private String penaltyAmount;

    @XmlElement(name = "RepaymentAcctId", namespace = "http://www.finacle.com/fixml")
    private String repaymentAcctId;

    @XmlElement(name = "FDClosureAmount", namespace = "http://www.finacle.com/fixml")
    private String fdClosureAmount;

    @XmlElement(name = "ErrorCode", namespace = "http://www.finacle.com/fixml")
    private String errorCode;

    @XmlElement(name = "ReplyCode", namespace = "http://www.finacle.com/fixml")
    private String replyCode;

    @XmlElement(name = "ReplyText", namespace = "http://www.finacle.com/fixml")
    private String replyText;

    @XmlElement(name = "MSG", namespace = "http://www.finacle.com/fixml")
    private String mSG;

    //Extra Response tags for TDAcctClose which are missing above

    @XmlElement(name = "Result", namespace = "http://www.finacle.com/fixml")
    private String Result;

    @XmlElement(name = "TranId", namespace = "http://www.finacle.com/fixml")
    private String TranId;

    @XmlElement(name = "TranDate", namespace = "http://www.finacle.com/fixml")
    private String TranDate;




}
