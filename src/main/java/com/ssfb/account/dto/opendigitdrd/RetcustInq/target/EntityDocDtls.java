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
public class EntityDocDtls {
    @XmlElement(name = "CountryOfIssue", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String countryOfIssue;

    @XmlElement(name = "DocCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String docCode;

    @XmlElement(name = "IsDocDeleted", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String isDocDeleted;

    @XmlElement(name = "DocExpDt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String docExpDt;

    @XmlElement(name = "DocIssueDt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String docIssueDt;

    @XmlElement(name = "DocRmks", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String docRmks;

    @XmlElement(name = "DocTypeCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String docTypeCode;

    @XmlElement(name = "DocTypeDesc", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String docTypeDesc;

    @XmlElement(name = "EntityType", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String entityType;

    @XmlElement(name = "IdentificationType", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String identificationType;

    @XmlElement(name = "PlaceOfIssue", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String placeOfIssue;

    @XmlElement(name = "RefNum", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String refNum;

    @XmlElement(name = "Status", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String status;

    @XmlElement(name = "EntityDocumentID", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String entityDocumentID;

    @XmlElement(name = "IsDocumentVerified", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String isDocumentVerified;

    @XmlElement(name = "PreferredUniqueId", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String preferredUniqueId;

    @XmlElement(name = "Type", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String type;

    @XmlElement(name = "IDIssuedOrganisation", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String idIssuedOrganisation;

    @XmlElement(name = "ScanRequired", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String scanRequired;

    @XmlElement(name = "IsMandatory", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String isMandatory;

    @XmlElement(name = "DocDescr", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String docDescr;
}
