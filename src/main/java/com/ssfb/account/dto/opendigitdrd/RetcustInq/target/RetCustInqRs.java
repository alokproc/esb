package com.ssfb.account.dto.opendigitdrd.RetcustInq.target;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class RetCustInqRs {
    @XmlElement(name = "RetCustDtls", namespace = "http://www.finacle.com/fixml", nillable = true)
    private RetCustDtls retCustDtls;
    @XmlElement(name = "DemographicDtls", namespace = "http://www.finacle.com/fixml", nillable = true)
    private DemographicDtls demographicDtls;
    @XmlElement(name = "EntityDocDtls", namespace = "http://www.finacle.com/fixml", nillable = true)
    private List<EntityDocDtls> entityDocDtls;
    @XmlElement(name = "MappingDtls", namespace = "http://www.finacle.com/fixml", nillable = true)
    private MappingDtls mappingDtls;
    @XmlElement(name = "PsychographicDtls", namespace = "http://www.finacle.com/fixml", nillable = true)
    private PsychographicDtls psychographicDtls;
    @XmlElement(name = "RelBankDtls", namespace = "http://www.finacle.com/fixml", nillable = true)
    private RelBankDtls relBankDtls;
    @XmlElement(name = "TradeFinDtls", namespace = "http://www.finacle.com/fixml", nillable = true)
    private TradeFinDtls tradeFinDtls;
    @XmlElement(name = "RetailBaselDtls", namespace = "http://www.finacle.com/fixml", nillable = true)
    private RetailBaselDtls retailBaselDtls;
    @XmlElement(name = "relationshipData", namespace = "http://www.finacle.com/fixml", nillable = true)
    private List<RelationshipData> relationshipData;
    @XmlElement(name = "coreInterfaceDtls", namespace = "http://www.finacle.com/fixml", nillable = true)
    private CoreInterfaceDtls coreInterfaceDtls;
}
