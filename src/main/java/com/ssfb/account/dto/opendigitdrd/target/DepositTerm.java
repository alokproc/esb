package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class DepositTerm {
    @XmlElement(name = "Months", namespace = "http://www.finacle.com/fixml")
    private String months;

    @XmlElement(name = "Days", namespace = "http://www.finacle.com/fixml")
    private String days;
}
