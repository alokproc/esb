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
public class IntCalcFreq {
    @XmlElement(name = "Cal", namespace = "http://www.finacle.com/fixml")
    private String cal;

    @XmlElement(name = "Type", namespace = "http://www.finacle.com/fixml")
    private String type;

    @XmlElement(name = "StartDt", namespace = "http://www.finacle.com/fixml")
    private String startDt;

    @XmlElement(name = "WeekDay", namespace = "http://www.finacle.com/fixml")
    private String weekDay;

    @XmlElement(name = "WeekNum", namespace = "http://www.finacle.com/fixml")
    private String weekNum;

    @XmlElement(name = "HolStat", namespace = "http://www.finacle.com/fixml")
    private String holStat;
}
