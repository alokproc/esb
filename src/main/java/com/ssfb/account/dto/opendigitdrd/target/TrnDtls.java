package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class TrnDtls {
    @XmlElement(name = "TrnType", namespace = "http://www.finacle.com/fixml")
    private String trnType;

    @XmlElement(name = "TrnSubType", namespace = "http://www.finacle.com/fixml")
    private String trnSubType;

    @XmlElement(name = "DebitAcctId", namespace = "http://www.finacle.com/fixml")
    private DebitAcctId debitAcctId;
}
