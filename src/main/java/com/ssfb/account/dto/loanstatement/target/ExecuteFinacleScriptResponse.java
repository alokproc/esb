package com.ssfb.account.dto.loanstatement.target;

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
public class ExecuteFinacleScriptResponse {
    @XmlElement(name = "ExecuteFinacleScriptOutputVO", namespace = "http://www.finacle.com/fixml")
    private String executeFinacleScriptOutputVO; // Adjust type as needed

    @XmlElement(name = "executeFinacleScript_CustomData", namespace = "http://www.finacle.com/fixml")
    private ExecuteFinacleScriptCustomData executeFinacleScriptCustomData;
}

