package com.ssfb.account.dto.fetchutrdetails.target;

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
public class RequestMessageInfo {
    @XmlElement(name = "BankId", namespace = "http://www.finacle.com/fixml")
    private String bankId;

    @XmlElement(name = "TimeZone", namespace = "http://www.finacle.com/fixml")
    private String timeZone="";

    @XmlElement(name = "EntityId", namespace = "http://www.finacle.com/fixml")
    private String entityId;

    @XmlElement(name = "EntityType", namespace = "http://www.finacle.com/fixml")
    private String entityType;

    @XmlElement(name = "ArmCorrelationId", namespace = "http://www.finacle.com/fixml")
    private String armCorrelationId;

    @XmlElement(name = "MessageDateTime", namespace = "http://www.finacle.com/fixml")
    private String MessageDateTime;

}