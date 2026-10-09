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
public class Header {

    @XmlElement(name = "RequestHeader", namespace = "http://www.finacle.com/fixml")
    private RequestHeader requestHeader;

    @XmlElement(name = "ResponseHeader", namespace = "http://www.finacle.com/fixml")
    public ResponseHeader responseHeader;

}