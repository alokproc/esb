package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class GenLedgerSubHead {
    @XmlElement(name = "GenLedgerSubHeadCode", namespace = "http://www.finacle.com/fixml")
    private String genLedgerSubHeadCode;

    @XmlElement(name = "CurCode", namespace = "http://www.finacle.com/fixml")
    private String curCode;
}
