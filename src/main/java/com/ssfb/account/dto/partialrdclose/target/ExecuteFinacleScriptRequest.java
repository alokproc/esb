package com.ssfb.account.dto.partialrdclose.target;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class ExecuteFinacleScriptRequest {

    @XmlElement(name = "ExecuteFinacleScriptInputVO", namespace = "http://www.finacle.com/fixml")
    private ExecuteFinacleScriptInputVO executeFinacleScriptInputVO;

    @XmlElement(name = "executeFinacleScript_CustomData", namespace = "http://www.finacle.com/fixml")
    private ExecuteFinacleScriptCustomData executeFinacleScriptCustomData;

}
