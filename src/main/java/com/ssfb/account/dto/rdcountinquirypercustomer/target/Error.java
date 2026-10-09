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
public class Error {

    @XmlElement(name = "FIBusinessException", namespace = "http://www.finacle.com/fixml")
    private FIBusinessException fiBusinessException;

    @XmlElement(name = "FISystemException", namespace = "http://www.finacle.com/fixml")
    private FISystemException fiSystemException;
}
