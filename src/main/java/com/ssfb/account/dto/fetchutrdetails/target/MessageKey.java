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
public class MessageKey {
    @XmlElement(name = "RequestUUID", namespace = "http://www.finacle.com/fixml")
    private String requestUUID;

    @XmlElement(name = "ServiceRequestId", namespace = "http://www.finacle.com/fixml")
    private String serviceRequestId = "executeFinacleScript"    ;

    @XmlElement(name = "ServiceRequestVersion", namespace = "http://www.finacle.com/fixml")
    private String serviceRequestVersion = "10.2";

    @XmlElement(name = "ChannelId", namespace = "http://www.finacle.com/fixml")
    private String channelId;

    @XmlElement(name = "LanguageId", namespace = "http://www.finacle.com/fixml")
    private String languageId;

}