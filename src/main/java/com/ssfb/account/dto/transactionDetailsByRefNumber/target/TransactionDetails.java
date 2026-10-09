package com.ssfb.account.dto.transactionDetailsByRefNumber.target;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionDetails {

    @XmlElement(name = "TRANDATE", namespace = "http://www.finacle.com/fixml")
    private String transactionDate;

    @XmlElement(name = "TRANAMT", namespace = "http://www.finacle.com/fixml")
    private String transactionAmount;

    @XmlElement(name = "TRANPART", namespace = "http://www.finacle.com/fixml")
    private String transactionParticulars;

    @XmlElement(name = "TRANID", namespace = "http://www.finacle.com/fixml")
    private String transactionId;

    @XmlElement(name = "FORACID", namespace = "http://www.finacle.com/fixml")
    private String forAccountId;
}
