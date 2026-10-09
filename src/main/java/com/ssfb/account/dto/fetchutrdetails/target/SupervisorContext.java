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
public class SupervisorContext {

    @XmlElement(name = "primaryPassword", namespace = "http://www.finacle.com/fixml")
    private String primaryPassword="";

    @XmlElement(name = "userId", namespace = "http://www.finacle.com/fixml")
    private String userId="";

}
