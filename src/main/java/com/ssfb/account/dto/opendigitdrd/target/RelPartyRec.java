package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class RelPartyRec {
    @XmlElement(name = "RelPartyType", namespace = "http://www.finacle.com/fixml")
    private String relPartyType;

    @XmlElement(name = "RelPartyCode", namespace = "http://www.finacle.com/fixml")
    private String relPartyCode;

    @XmlElement(name = "CustId", namespace = "http://www.finacle.com/fixml")
    private CustId custId;
}
