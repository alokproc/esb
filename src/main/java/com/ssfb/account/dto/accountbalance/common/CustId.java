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
public class CustId {
    @XmlElement(name = "CustId", namespace = "http://www.finacle.com/fixml")
    private String custId;

    @XmlElement(name = "PersonName", namespace = "http://www.finacle.com/fixml")
    private PersonName personName;
}
