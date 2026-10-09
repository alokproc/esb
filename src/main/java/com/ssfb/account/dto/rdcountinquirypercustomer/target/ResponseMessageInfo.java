package com.ssfb.account.dto.rdcountinquirypercustomer.target;

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
public class ResponseMessageInfo {
    @XmlElement(name = "BankId", namespace = "http://www.finacle.com/fixml")
    private String bankId;

    @XmlElement(name = "TimeZone", namespace = "http://www.finacle.com/fixml")
    private String timeZone;

    @XmlElement(name = "MessageDateTime", namespace = "http://www.finacle.com/fixml")
    private String messageDateTime;
}