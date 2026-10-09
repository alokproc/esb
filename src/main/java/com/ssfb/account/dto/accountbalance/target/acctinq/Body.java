package com.ssfb.account.dto.accountbalance.target.acctinq;

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
    @XmlElement(name = "AcctInqRequest", namespace = "http://www.finacle.com/fixml")
    private AcctInqRequest acctInqRequest;

    @XmlElement(name = "AcctInqResponse", namespace = "http://www.finacle.com/fixml")
    private AcctInqResponse acctInqResponse;

    @XmlElement(name = "Error", namespace = "http://www.finacle.com/fixml")
    private CommonError error;
}
