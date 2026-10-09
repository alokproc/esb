package com.ssfb.account.dto.accountbalance.target.caacct;

import com.ssfb.commonmodule.dto.fixml.CommonError;
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
public class Body {
    @XmlElement(name = "CAAcctInqRequest", namespace = "http://www.finacle.com/fixml")
    private CAAcctInqRequest caAcctInqRequest;

    @XmlElement(name = "CAAcctInqResponse", namespace = "http://www.finacle.com/fixml")
    private CAAcctInqResponse caAcctInqResponse;

    @XmlElement(name = "Error", namespace = "http://www.finacle.com/fixml")
    private CommonError error;
}