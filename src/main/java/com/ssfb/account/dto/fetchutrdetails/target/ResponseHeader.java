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
public class ResponseHeader {

    @XmlElement(name = "RequestMessageKey", namespace = "http://www.finacle.com/fixml")
    private RequestMessageKey requestMessageKey;

    @XmlElement(name = "ResponseMessageInfo", namespace = "http://www.finacle.com/fixml")
    private ResponseMessageInfo responseMessageInfo;

    @XmlElement(name = "UBUSTransaction", namespace = "http://www.finacle.com/fixml")
    private Transaction ubusTransaction;

    @XmlElement(name = "HostTransaction", namespace = "http://www.finacle.com/fixml")
    private Transaction hostTransaction;

    @XmlElement(name = "HostParentTransaction", namespace = "http://www.finacle.com/fixml")
    private Transaction hostParentTransaction;

    @XmlElement(name = "CustomInfo", namespace = "http://www.finacle.com/fixml")
    private String customInfo; // Adjust type as necessary
}
