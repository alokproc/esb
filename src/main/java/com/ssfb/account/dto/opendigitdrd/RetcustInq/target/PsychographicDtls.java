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
public class PsychographicDtls {
    @XmlElement(name = "DespatchMode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String despatchMode;

    @XmlElement(name = "HouseHoldNum", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String houseHoldNum;

    @XmlElement(name = "PrefAddrMode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String prefAddrMode;

    @XmlElement(name = "PrefRep", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String prefRep;

    @XmlElement(name = "PrefName", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String prefName;

    @XmlElement(name = "RiskBehaviour", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String riskBehaviour;

    @XmlElement(name = "SegmentationClass", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String segmentationClass;

    @XmlElement(name = "StmtFreq", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String stmtFreq;

    @XmlElement(name = "StmtType", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String stmtType;

    @XmlElement(name = "StmtDtWeekDay", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String stmtDtWeekDay;

    @XmlElement(name = "StmtDateWeekDay", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String stmtDateWeekDay;

    @XmlElement(name = "StmtWeekOfMonth", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String stmtWeekOfMonth;

    @XmlElement(name = "External_System_Pricing", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String externalSystemPricing;

    @XmlElement(name = "Relationship_Pricing_ID", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String relationshipPricingId;

    @XmlElement(name = "NumberofDependantChildren", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String numberOfDependantChildren;

    @XmlElement(name = "NumberofDependants", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String numberOfDependants;

    @XmlElement(name = "PrefMiscInqDtls", namespace = "http://www.finacle.com/fixml", nillable = true)
    private PrefMiscInqDtls prefMiscInqDtls;
}
