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
public class ErrorDetail {

    @XmlElement(name = "ErrorCode", namespace = "http://www.finacle.com/fixml")
    private String errorCode;

    @XmlElement(name = "ErrorDesc", namespace = "http://www.finacle.com/fixml")
    private String errorDesc;

    @XmlElement(name = "ErrorSource", namespace = "http://www.finacle.com/fixml")
    private String errorSource;

    @XmlElement(name = "ErrorType", namespace = "http://www.finacle.com/fixml")
    private String errorType;

}
