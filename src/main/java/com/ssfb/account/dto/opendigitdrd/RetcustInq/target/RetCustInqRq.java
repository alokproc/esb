package com.ssfb.account.dto.opendigitdrd.RetcustInq.target;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class RetCustInqRq {

    @XmlElement(name = "CustId", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String custId;
}
