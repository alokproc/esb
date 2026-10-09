package com.ssfb.account.dto.accountbalance.target.acctinq;

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
public class CustStat {
    @XmlElement(name = "refCode", namespace = "http://www.finacle.com/fixml")
    public String refCode;

    @XmlElement(name = "refRecType", namespace = "http://www.finacle.com/fixml")
    public String refRecType;

    @XmlElement(name = "refDesc", namespace = "http://www.finacle.com/fixml")
    public String refDesc;
}
