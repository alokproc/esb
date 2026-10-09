package com.ssfb.account.dto.transactionDetailsByRefNumber.target;

import com.ssfb.commonmodule.dto.fixml.CommonError;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)

public class Body {

    @XmlElement(name = "executeFinacleScriptRequest", namespace = "http://www.finacle.com/fixml")
    private ExecuteFinacleScriptRequest executeFinacleScriptRequest;

    @XmlElement(name = "executeFinacleScriptResponse", namespace = "http://www.finacle.com/fixml")
    private ExecuteFinacleScriptResponse executeFinacleScriptResponse;

    @XmlElement(name = "Error", namespace = "http://www.finacle.com/fixml")
    private CommonError error;

}
