package com.ssfb.account.dto.opendigitdrd.target;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class TDAcctAddRs {
    @XmlElement(name = "TDAcctId", namespace = "http://www.finacle.com/fixml")
    private TDAcctId tdAcctId;

}
