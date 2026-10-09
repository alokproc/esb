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
public class DemographicDtls {
    @XmlElement(name = "DonotCallFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String donotCallFlag;

    @XmlElement(name = "DonotMailFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String donotMailFlag;

    @XmlElement(name = "DonotSendEMailFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String donotSendEMailFlag;

    @XmlElement(name = "NameOfEmployer", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String nameOfEmployer;

    @XmlElement(name = "EmploymentStatus", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String employmentStatus;

    @XmlElement(name = "MaritalStatus", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String maritalStatus;

    @XmlElement(name = "Nationality", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String nationality;

    @XmlElement(name = "MaritalStatusCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String maritalStatusCode;

    @XmlElement(name = "NationalityCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String nationalityCode;

    @XmlElement(name = "PrefContactTime", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String prefContactTime;

    @XmlElement(name = "PrefDayTimeContactNum", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String prefDayTimeContactNum;

    @XmlElement(name = "PrefDayTimeContactNumArea", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String prefDayTimeContactNumArea;

    @XmlElement(name = "PrefDayTimeContactNumCountry", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String prefDayTimeContactNumCountry;

    @XmlElement(name = "PrefDayTimeContactNumLocal", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String prefDayTimeContactNumLocal;

    @XmlElement(name = "ResidenceCountry", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String residenceCountry;

    @XmlElement(name = "ResidenceCountryCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String residenceCountryCode;

    @XmlElement(name = "Tax_Rate_Table_Code", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String taxRateTableCode;

    @XmlElement(name = "Income_Nature", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String incomeNature;
}
