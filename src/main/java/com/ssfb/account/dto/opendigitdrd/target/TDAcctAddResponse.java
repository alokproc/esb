package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class TDAcctAddResponse {
    @XmlElement(name = "TDAcctAddRs", namespace = "http://www.finacle.com/fixml")
    private TDAcctAddRs tdAcctAddRs;

    @XmlElement(name = "TDAcctAdd_CustomData", namespace = "http://www.finacle.com/fixml")
    private TDAcctAddCustomData tdAcctAddCustomData;
}
