package com.ssfb.account.dto.rrninquiry.target;

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
public class ExecuteFinacleScriptRequest {
    @XmlElement(name = "ExecuteFinacleScriptInputVO", namespace = "http://www.finacle.com/fixml")
    private ExecuteFinacleScriptInputVO inputVO;

    @XmlElement(name = "executeFinacleScript_CustomData", namespace = "http://www.finacle.com/fixml")
    private ExecuteFinacleScriptCustomData customData;
}
