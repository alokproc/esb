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
public class RelPartyRec {
    @XmlElement(name = "RelPartyType", namespace = "http://www.finacle.com/fixml")
    private String relPartyType;

    @XmlElement(name = "RelPartyTypeDesc", namespace = "http://www.finacle.com/fixml")
    private String relPartyTypeDesc;

    @XmlElement(name = "RelPartyCode", namespace = "http://www.finacle.com/fixml")
    private String relPartyCode;

    @XmlElement(name = "RelPartyCodeDesc", namespace = "http://www.finacle.com/fixml")
    private String relPartyCodeDesc;

    @XmlElement(name = "CustId", namespace = "http://www.finacle.com/fixml")
    private CustId custId;

    @XmlElement(name = "RelPartyContactInfo", namespace = "http://www.finacle.com/fixml")
    private RelPartyContactInfo relPartyContactInfo;

    @XmlElement(name = "RecDelFlg", namespace = "http://www.finacle.com/fixml")
    private String recDelFlg;

}
