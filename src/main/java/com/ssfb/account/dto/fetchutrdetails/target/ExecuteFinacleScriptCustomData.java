package com.ssfb.account.dto.fetchutrdetails.target;

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
public class ExecuteFinacleScriptCustomData {

    //request
    @XmlElement(name = "CHQ_NUMBER", namespace = "http://www.finacle.com/fixml")
    private String chqNumber;

    @XmlElement(name = "UTR_NUMBER", namespace = "http://www.finacle.com/fixml")
    private String UtrNumber;

    @XmlElement(name = "TRAN_DATE", namespace = "http://www.finacle.com/fixml")
    private String tranDate;

    //response

    @XmlElement(name = "tran_amt", namespace = "http://www.finacle.com/fixml")
    private String tranAmount;

    @XmlElement(name = "SENDER_BIC", namespace = "http://www.finacle.com/fixml")
    private String senderBic;

    @XmlElement(name = "PAYSYS_ID", namespace = "http://www.finacle.com/fixml")
    private String paysysId;

    @XmlElement(name = "LCHG_TIME", namespace = "http://www.finacle.com/fixml")
    private String lchgTime;

    @XmlElement(name = "STATUS", namespace = "http://www.finacle.com/fixml")
    private String status;

    @XmlElement(name = "REASON", namespace = "http://www.finacle.com/fixml")
    private String reason;

    @XmlElement(name = "ORD_PARTY_ACCT", namespace = "http://www.finacle.com/fixml")
    private String ordPartyAcct;

    @XmlElement(name = "ORD_PARTY_NAME", namespace = "http://www.finacle.com/fixml")
    private String ordPartyName;

}
