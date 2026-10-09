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
public class RelationshipData {
    @XmlElement(name = "AllowModify", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String allowModify;

    @XmlElement(name = "ChildBackEndID", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String childBackEndID;

    @XmlElement(name = "ChildCIFID", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String childCIFID;

    @XmlElement(name = "ChildEntity", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String childEntity;

    @XmlElement(name = "ChildEntityType", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String childEntityType;

    @XmlElement(name = "ContactName", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String contactName;

    @XmlElement(name = "KnownYears", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String knownYears;

    @XmlElement(name = "PrimaryIntroducer", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String primaryIntroducer;

    @XmlElement(name = "RelationShip", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String relationShip;

    @XmlElement(name = "RelationshipCategory", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String relationshipCategory;

    @XmlElement(name = "GuardCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String guardCode;

    @XmlElement(name = "DeleteFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String deleteFlag;

    @XmlElement(name = "EntityRelationshipID", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String entityRelationshipID;

    @XmlElement(name = "ChildBackendType", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String childBackendType;

    @XmlElement(name = "Relationship_Code", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String relationshipCode;

    @XmlElement(name = "ParentEntityType", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String parentEntityType;

    @XmlElement(name = "ParentCIFID", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String parentCIFID;

    @XmlElement(name = "ParentEntity", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String parentEntity;

    @XmlElement(name = "CoreCustID", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String coreCustID;

    @XmlElement(name = "CoreChildCustID", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String coreChildCustID;
}
