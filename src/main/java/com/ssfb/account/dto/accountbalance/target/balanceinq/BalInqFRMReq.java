package com.ssfb.account.dto.accountbalance.target.balanceinq;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "Request", namespace = "http://www.suryodaybank.com/Account/FRM/Clarifive")
@XmlAccessorType(XmlAccessType.FIELD)
public class BalInqFRMReq {

    @XmlElement(name = "Operation", namespace = "http://www.suryodaybank.com/Account/FRM/Clarifive")
    private String operation;

    @XmlElement(name = "Payload", namespace = "http://www.suryodaybank.com/Account/FRM/Clarifive")
    private String payload;

    @XmlElement(name = "MsgBody", namespace = "http://www.suryodaybank.com/Account/FRM/Clarifive")
    private String msgBody;

    @XmlElement(name = "event_id", namespace = "http://www.suryodaybank.com/Account/FRM/Clarifive")
    private String eventId;

    @XmlElement(name = "cust_id", namespace = "http://www.suryodaybank.com/Account/FRM/Clarifive")
    private String custId;

    @XmlElement(name = "event_ts", namespace = "http://www.suryodaybank.com/Account/FRM/Clarifive")
    private long eventTimestamp;

    @XmlElement(name = "eventtype", namespace = "http://www.suryodaybank.com/Account/FRM/Clarifive")
    private String eventType;

    @XmlElement(name = "eventsubtype", namespace = "http://www.suryodaybank.com/Account/FRM/Clarifive")
    private String eventSubType;

    @XmlElement(name = "eventname", namespace = "http://www.suryodaybank.com/Account/FRM/Clarifive")
    private String eventName;

    @XmlElement(name = "source", namespace = "http://www.suryodaybank.com/Account/FRM/Clarifive")
    private String source;
}
