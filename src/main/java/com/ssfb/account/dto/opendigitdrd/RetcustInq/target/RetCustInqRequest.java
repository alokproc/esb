package com.ssfb.account.dto.opendigitdrd.RetcustInq.target;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class RetCustInqRequest {

    @XmlElement(name = "RetCustInqRq", namespace = "http://www.finacle.com/fixml", nillable = true)
    private RetCustInqRq retCustInqRq;
}
