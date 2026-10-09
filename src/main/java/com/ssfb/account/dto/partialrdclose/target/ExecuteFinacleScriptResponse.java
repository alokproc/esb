package com.ssfb.account.dto.partialrdclose.target;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class ExecuteFinacleScriptResponse {

    @XmlElement(name = "ExecuteFinacleScriptOutputVO", namespace = "http://www.finacle.com/fixml")
    private String executeFinacleScriptOutputVO;

    @XmlElement(name = "executeFinacleScript_CustomData", namespace = "http://www.finacle.com/fixml")
    private ExecuteFinacleScriptCustomData executeFinacleScriptCustomData;
}
