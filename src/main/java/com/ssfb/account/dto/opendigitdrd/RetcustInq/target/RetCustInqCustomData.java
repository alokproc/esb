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
public class RetCustInqCustomData {
    @XmlElement(name = "NAME_MATCH_SCORE", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String nameMatchScore;

    @XmlElement(name = "AADHAR_AND_PAN_LINK_STATUS", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String aadharAndPanLinkStatus;

    @XmlElement(name = "LIVELINESS_CHECK", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String livelinessCheck;

    @XmlElement(name = "CU_CUSTNETWORTH", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String cuCustNetworth;

    @XmlElement(name = "CUSTNETWORTH", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String custNetworth;

    @XmlElement(name = "SMSCustomer", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String smsCustomer;

    @XmlElement(name = "EmailAddress", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String emailAddress;
}
