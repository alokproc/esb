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
public class WithHoldingTaxDtls {
    @XmlElement(name = "TaxCategory", namespace = "http://www.finacle.com/fixml")
    private String taxCategory;

    @XmlElement(name = "FloorLimitAmt", namespace = "http://www.finacle.com/fixml")
    private Amount floorLimitAmt;

    @XmlElement(name = "WithHoldingPercent", namespace = "http://www.finacle.com/fixml")
    private InterestRate withHoldingPercent;
}
