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
public class AcctInqRequest {
    @XmlElement(name = "AcctInqRq", namespace = "http://www.finacle.com/fixml")
    private AcctInqRq acctInqRq;
}
