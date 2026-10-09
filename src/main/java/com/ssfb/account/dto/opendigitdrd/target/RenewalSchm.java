package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class RenewalSchm {
    @XmlElement(name = "SchmCode", namespace = "http://www.finacle.com/fixml")
    private String schmCode;

    @XmlElement(name = "SchmType", namespace = "http://www.finacle.com/fixml")
    private String schmType;
}
