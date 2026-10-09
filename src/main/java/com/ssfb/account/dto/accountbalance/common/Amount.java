package com.ssfb.account.dto.accountbalance.common;

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
public class Amount {
    @XmlElement(name = "amountValue", namespace = "http://www.finacle.com/fixml")
    private String amountValue;

    @XmlElement(name = "currencyCode", namespace = "http://www.finacle.com/fixml")
    private String currencyCode;
}
