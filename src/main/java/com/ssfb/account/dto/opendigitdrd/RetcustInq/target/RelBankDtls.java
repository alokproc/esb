package com.ssfb.account.dto.opendigitdrd.RetcustInq.target;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class RelBankDtls {
    @XmlElement(name = "OrgKey", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String orgKey;

    @XmlElement(name = "EntityCreationFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String entityCreationFlag;

    @XmlElement(name = "NumOfCrCards", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String numOfCrCards;
}
