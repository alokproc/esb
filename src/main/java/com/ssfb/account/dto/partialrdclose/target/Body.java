package com.ssfb.account.dto.partialrdclose.target;

import com.ssfb.commonmodule.dto.fixml.CommonError;
import com.ssfb.commonmodule.dto.fixml.CommonHeaders;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

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
