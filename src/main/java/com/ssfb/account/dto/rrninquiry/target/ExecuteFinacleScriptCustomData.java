package com.ssfb.account.dto.rrninquiry.target;

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
    @XmlElement(name = "RRN", namespace = "http://www.finacle.com/fixml")
    private String rrn;

    @XmlElement(name = "TRANSACTION_DATE", namespace = "http://www.finacle.com/fixml")
    private String transactionDate;

    @XmlElement(name = "TRANSACTION_AMOUNT", namespace = "http://www.finacle.com/fixml")
    private String transactionAmount;

    @XmlElement(name = "CUSTOMER_NAME", namespace = "http://www.finacle.com/fixml")
    private String customerName;

    @XmlElement(name = "CUSTOMER_ACCOUNT", namespace = "http://www.finacle.com/fixml")
    private String customerAccount;

    @XmlElement(name = "CUSTOMER_MOBILE", namespace = "http://www.finacle.com/fixml")
    private String customerMobile;

    @XmlElement(name = "CUSTOMER_IFSC", namespace = "http://www.finacle.com/fixml")
    private String customerIFSC;

    @XmlElement(name = "RESULT_MSG", namespace = "http://www.finacle.com/fixml")
    private String resultMsg;
}
