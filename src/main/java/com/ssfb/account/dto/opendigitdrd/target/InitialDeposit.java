package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class InitialDeposit {
    @XmlElement(name = "amountValue", namespace = "http://www.finacle.com/fixml")
    private String amountValue;

    @XmlElement(name = "currencyCode", namespace = "http://www.finacle.com/fixml")
    private String currencyCode;
}
