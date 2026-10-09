package com.ssfb.account.dto.transactionDetailsByRefNumber.target;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class ExecuteFinacleScriptCustomData {

    @XmlElement(name = "Reference_Number", namespace = "http://www.finacle.com/fixml")
    private String referenceNumber;

    //response

    @XmlElement(name = "TRANSACTION_DETAILS", namespace = "http://www.finacle.com/fixml")
    private List<TransactionDetails> transactionDetails;
}
