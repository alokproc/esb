package com.ssfb.account.dto.fetchutrdetails.target;

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
public class ExecuteFinacleScriptInputVO {

    @XmlElement(name = "requestId", namespace = "http://www.finacle.com/fixml")
    private String requestId = "C_QB_UTR_CHEQUE_API.scr";
}