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
public class RequestHeader {

    @XmlElement(name = "MessageKey", namespace = "http://www.finacle.com/fixml")
    private MessageKey messageKey;

    @XmlElement(name = "RequestMessageInfo", namespace = "http://www.finacle.com/fixml")
    private RequestMessageInfo requestMessageInfo;
}