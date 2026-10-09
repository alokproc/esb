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
public class RetCustAddrInfo {

    @XmlElement(name = "AddrLine1", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String addrLine1;

    @XmlElement(name = "AddrLine2", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String addrLine2;

    @XmlElement(name = "AddrLine3", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String addrLine3;

    @XmlElement(name = "AddrStartDt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String addrStartDt;

    @XmlElement(name = "AddrCategory", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String addrCategory;

    @XmlElement(name = "BuildingLevel", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String buildingLevel;

    @XmlElement(name = "BusinessCenter", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String businessCenter;

    @XmlElement(name = "CellNum", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String cellNum;

    @XmlElement(name = "City", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String city;

    @XmlElement(name = "CityCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String cityCode;

    @XmlElement(name = "Country", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String country;

    @XmlElement(name = "CountryCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String countryCode;

    @XmlElement(name = "Domicile", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String domicile;

    @XmlElement(name = "Email", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String email;

    @XmlElement(name = "EndDt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String endDt;

    @XmlElement(name = "FaxNum", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String faxNum;

    @XmlElement(name = "FaxNumCityCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String faxNumCityCode;

    @XmlElement(name = "FaxNumCountryCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String faxNumCountryCode;

    @XmlElement(name = "FaxNumLocalCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String faxNumLocalCode;

    @XmlElement(name = "HoldMailFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String holdMailFlag;

    @XmlElement(name = "HoldMailInitiatedBy", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String holdMailInitiatedBy;

    @XmlElement(name = "HoldMailReason", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String holdMailReason;

    @XmlElement(name = "HouseNum", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String houseNum;

    @XmlElement(name = "LocalityName", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String localityName;

    @XmlElement(name = "MailStop", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String mailStop;

    @XmlElement(name = "Name", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String name;

    @XmlElement(name = "PagerNum", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String pagerNum;

    @XmlElement(name = "PagerNumCityCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String pagerNumCityCode;

    @XmlElement(name = "PagerNumCcountryCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String pagerNumCcountryCode;

    @XmlElement(name = "PagerNumLocalCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String pagerNumLocalCode;

    @XmlElement(name = "PhoneNum1", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String phoneNum1;

    @XmlElement(name = "PrefAddr", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String prefAddr;

    @XmlElement(name = "PrefFormat", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String prefFormat;

    @XmlElement(name = "PremiseName", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String premiseName;

    @XmlElement(name = "ResidentialStatus", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String residentialStatus;

    @XmlElement(name = "SalutationCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String salutationCode;

    @XmlElement(name = "State", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String state;

    @XmlElement(name = "StateCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String stateCode;

    @XmlElement(name = "StreetName", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String streetName;

    @XmlElement(name = "StreetNum", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String streetNum;

    @XmlElement(name = "Suburb", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String suburb;

    @XmlElement(name = "Telex", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String telex;

    @XmlElement(name = "TelexCityCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String telexCityCode;

    @XmlElement(name = "TelexCountryCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String telexCountryCode;

    @XmlElement(name = "TelexLocalCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String telexLocalCode;

    @XmlElement(name = "Town", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String town;

    @XmlElement(name = "PostalCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String postalCode;

    @XmlElement(name = "isAddressVerified", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String isAddressVerified;

    @XmlElement(name = "AddressID", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String addressID;
}
