package com.ssfb.account.dto.partialrdclose.target;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class ExecuteFinacleScriptInputVO {

    @XmlElement(name = "requestId", namespace = "http://www.finacle.com/fixml")
    private String requestId;
}
