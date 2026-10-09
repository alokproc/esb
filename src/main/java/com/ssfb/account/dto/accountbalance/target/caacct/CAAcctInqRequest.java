package com.ssfb.account.dto.accountbalance.target.caacct;

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
public class CAAcctInqRequest {
    @XmlElement(name = "CAAcctInqRq", namespace = "http://www.finacle.com/fixml")
    private CAAcctInqRq caAcctInqRq;
}
