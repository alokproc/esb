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
public class RetCustInqResponse {
    @XmlElement(name = "RetCustInqRs", namespace = "http://www.finacle.com/fixml", nillable = true)
    private RetCustInqRs retCustInqRs;
    @XmlElement(name = "RetCustInq_CustomData", namespace = "http://www.finacle.com/fixml", nillable = true)
    private RetCustInqCustomData retCustInqCustomData;
}
