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
public class TradeFinDtls {
    @XmlElement(name = "CautionStat", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String cautionStat;

    @XmlElement(name = "CentralBankId", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String centralBankId;

    @XmlElement(name = "City", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String city;

    @XmlElement(name = "ContractLimit", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String contractLimit;

    @XmlElement(name = "CountryDesc", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String countryDesc;

    @XmlElement(name = "CorpKey", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String corpKey;

    @XmlElement(name = "CorpName", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String corpName;

    @XmlElement(name = "CreatedFrom", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String createdFrom;

    @XmlElement(name = "CurrDesc", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String currDesc;

    @XmlElement(name = "CustFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String custFlag;

    @XmlElement(name = "CustNative", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String custNative;

    @XmlElement(name = "DCMmarginPercentage", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String dcmMarginPercentage;

    @XmlElement(name = "DCNextNumCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String dcNextNumCode;

    @XmlElement(name = "DCNextNumCodeRCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String dcNextNumCodeRCode;

    @XmlElement(name = "DCSanctionIngAuth", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String dcSanctionIngAuth;

    @XmlElement(name = "IsDeleted", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String isDeleted;

    @XmlElement(name = "EntityCreationFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String entityCreationFlag;

    @XmlElement(name = "EntityType", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String entityType;

    @XmlElement(name = "ExpImpInd", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String expImpInd;

    @XmlElement(name = "FaxNum", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String faxNum;

    @XmlElement(name = "FCSanctionIngAuth", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String fcSanctionIngAuth;

    @XmlElement(name = "HundredPercentFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String hundredPercentFlag;

    @XmlElement(name = "IndividualCorpFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String individualCorpFlag;

    @XmlElement(name = "InlandTradeAllowed", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String inlandTradeAllowed;

    @XmlElement(name = "LeasingLiabilities", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String leasingLiabilities;

    @XmlElement(name = "Name", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String name;

    @XmlElement(name = "OrgKey", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String orgKey;

    @XmlElement(name = "PartyConst", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String partyConst;

    @XmlElement(name = "PartyType", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String partyType;

    @XmlElement(name = "Phone", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String phone;

    @XmlElement(name = "PhoneCityCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String phoneCityCode;

    @XmlElement(name = "PhoneCountryCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String phoneCountryCode;

    @XmlElement(name = "PhoneLocalCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String phoneLocalCode;

    @XmlElement(name = "ProductionCycle", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String productionCycle;

    @XmlElement(name = "Rmks", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String rmks;

    @XmlElement(name = "SpecialCustFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String specialCustFlag;

    @XmlElement(name = "SSIFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String ssiFlag;

    @XmlElement(name = "StateDesc", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String stateDesc;

    @XmlElement(name = "Telex", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String telex;

    @XmlElement(name = "TradeAuthorityCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String tradeAuthorityCode;

    @XmlElement(name = "PostalCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String postalCode;

    @XmlElement(name = "PartyTypeCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String partyTypeCode;

    @XmlElement(name = "DCNextNorCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String dcNextNorCode;

    @XmlElement(name = "FCSanctionIngAuthCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String fcSanctionIngAuthCode;

    @XmlElement(name = "PartyConstCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String partyConstCode;

    @XmlElement(name = "ExpImpIndCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String expImpIndCode;
}
