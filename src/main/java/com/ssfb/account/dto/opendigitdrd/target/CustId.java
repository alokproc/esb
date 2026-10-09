package com.ssfb.account.dto.opendigitdrd.target;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class CustId {
    @XmlElement(name = "CustId", namespace = "http://www.finacle.com/fixml")
    private String custId;
}
