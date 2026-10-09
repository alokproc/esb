package com.ssfb.account.dto.accountbalance.target.sbacct;

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
    @XmlElement(name = "SBAcctInqRequest", namespace = "http://www.finacle.com/fixml")
    private SBAcctInqRequest sbAcctInqRequest;

    @XmlElement(name = "SBAcctInqResponse", namespace = "http://www.finacle.com/fixml")
    private SBAcctInqResponse sbAcctInqResponse;

    @XmlElement(name = "Error", namespace = "http://www.finacle.com/fixml")
    private CommonError error;
}
