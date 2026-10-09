package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class AcctStmtFreq {
    @XmlElement(name = "Type", namespace = "http://www.finacle.com/fixml")
    private String type;

    @XmlElement(name = "StartDt", namespace = "http://www.finacle.com/fixml")
    private String startDt;

    @XmlElement(name = "HolStat", namespace = "http://www.finacle.com/fixml")
    private String holStat;
}
