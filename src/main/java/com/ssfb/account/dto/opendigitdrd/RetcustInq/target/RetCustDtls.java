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
public class RetCustDtls {
    @XmlElement(name = "AcctName", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String acctName;

    @XmlElement(name = "AnnualRevenue", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String annualRevenue;

    @XmlElement(name = "Assistant", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String assistant;

    @XmlElement(name = "AvailableCrLimit", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String availableCrLimit;

    @XmlElement(name = "BlacklistNotes", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String blacklistNotes;

    @XmlElement(name = "BlacklistReason", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String blacklistReason;

    @XmlElement(name = "IsBlacklisted", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String isBlacklisted;

    @XmlElement(name = "CardHolder", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String cardHolder;

    @XmlElement(name = "Category", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String category;

    @XmlElement(name = "ChargeLevelCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String chargeLevelCode;

    @XmlElement(name = "CustId", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String custId;

    @XmlElement(name = "CIN", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String cin;

    @XmlElement(name = "City", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String city;

    @XmlElement(name = "CombinedStmtFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String combinedStmtFlag;

    @XmlElement(name = "ConstitutionCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String constitutionCode;

    @XmlElement(name = "ConstitutionRefCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String constitutionRefCode;

    @XmlElement(name = "CorpRepCount", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String corpRepCount;

    @XmlElement(name = "CountryOfBirth", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String countryOfBirth;

    @XmlElement(name = "CreatedFrom", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String createdFrom;

    @XmlElement(name = "CreatedBySystemId", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String createdBySystemId;

    @XmlElement(name = "CurrCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String currCode;

    @XmlElement(name = "CurrentCrExposure", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String currentCrExposure;

    @XmlElement(name = "CommunityCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String communityCode;

    @XmlElement(name = "Community", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String community;

    @XmlElement(name = "BirthDt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String birthDt;

    @XmlElement(name = "FirstName", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String firstName;

    @XmlElement(name = "FirstNameNative", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String firstNameNative;

    @XmlElement(name = "FirstNameNative1", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String firstNameNative1;

    @XmlElement(name = "LastName", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String lastName;

    @XmlElement(name = "MiddleName", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String middleName;

    @XmlElement(name = "Gender", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String gender;

    @XmlElement(name = "CustType", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String custType;

    @XmlElement(name = "CustClass", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String custClass;

    @XmlElement(name = "IsMinor", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String isMinor;

    @XmlElement(name = "IsNRE", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String isNre;

    @XmlElement(name = "Occupation", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String occupation;

    @XmlElement(name = "PAN", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String pan;

    @XmlElement(name = "PassportNum", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String passportNum;

    @XmlElement(name = "Phone", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String phone;
    @XmlElement(name = "PhoneEmailInfo", namespace = "http://www.finacle.com/fixml", nillable = true)
    private List<PhoneEmailInfo> phoneEmailInfo;
    @XmlElement(name = "PlaceOfBirth", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String placeOfBirth;

    @XmlElement(name = "PotentialCrLine", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String potentialCrLine;

    @XmlElement(name = "PrefCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String prefCode;

    @XmlElement(name = "PrefCodeRefCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String prefCodeRefCode;

    @XmlElement(name = "PrefName", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String prefName;

    @XmlElement(name = "PreviousName", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String previousName;

    @XmlElement(name = "PrimaryServiceCentre", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String primaryServiceCentre;

    @XmlElement(name = "PrimarySolId", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String primarySolId;

    @XmlElement(name = "PriorityCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String priorityCode;

    @XmlElement(name = "ProofOfAgeDoc", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String proofOfAgeDoc;

    @XmlElement(name = "ProofOfAgeFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String proofOfAgeFlag;

    @XmlElement(name = "PassportDtls", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String passportDtls;

    @XmlElement(name = "Rating", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String rating;

    @XmlElement(name = "RatingCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String ratingCode;

    @XmlElement(name = "Region", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String region;

    @XmlElement(name = "RelationshipLevel", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String relationshipLevel;

    @XmlElement(name = "RelationshipType", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String relationshipType;

    @XmlElement(name = "RelationshipOpeningDt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String relationshipOpeningDt;

    @XmlElement(name = "RelationshipValue", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String relationshipValue;
    @XmlElement(name = "RetCustAddrInfo", namespace = "http://www.finacle.com/fixml", nillable = true)
    private List<RetCustAddrInfo> retCustAddrInfo;
    @XmlElement(name = "RevenueUnits", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String revenueUnits;

    @XmlElement(name = "Salutation", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String salutation;

    @XmlElement(name = "SalutationCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String salutationCode;

    @XmlElement(name = "Sector", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String sector;

    @XmlElement(name = "SectorCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String sectorCode;

    @XmlElement(name = "SegmentationClass", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String segmentationClass;

    @XmlElement(name = "ShortName", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String shortName;

    @XmlElement(name = "ShortNameNative", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String shortNameNative;

    @XmlElement(name = "ShortNameNative1", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String shortNameNative1;

    @XmlElement(name = "SICCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String sicCode;

    @XmlElement(name = "SMSBankingMobNum", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String smsBankingMobNum;

    @XmlElement(name = "SSN", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String ssn;

    @XmlElement(name = "StaffFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String staffFlag;

    @XmlElement(name = "StartDt", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String startDt;

    @XmlElement(name = "Status", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String status;

    @XmlElement(name = "SubSector", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String subSector;

    @XmlElement(name = "SubSectorCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String subSectorCode;

    @XmlElement(name = "SubSegment", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String subSegment;

    @XmlElement(name = "SuspendNotes", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String suspendNotes;

    @XmlElement(name = "SuspendReason", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String suspendReason;

    @XmlElement(name = "IsSuspended", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String isSuspended;

    @XmlElement(name = "TFPartyFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String tfPartyFlag;

    @XmlElement(name = "TickerSymbol", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String tickerSymbol;

    @XmlElement(name = "TotalCrExposure", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String totalCrExposure;

    @XmlElement(name = "ForeignAccTaxReportingReq", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String foreignAccTaxReportingReq;

    @XmlElement(name = "ForeignTaxReportingCountry", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String foreignTaxReportingCountry;

    @XmlElement(name = "ForeignTaxReportingStatus", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String foreignTaxReportingStatus;

    @XmlElement(name = "LastForeignTaxReviewDate", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String lastForeignTaxReviewDate;

    @XmlElement(name = "NextForeignTaxReviewDate", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String nextForeignTaxReviewDate;

    @XmlElement(name = "FatcaRemarks", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String fatcaRemarks;

    @XmlElement(name = "DateOfDeath", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String dateOfDeath;

    @XmlElement(name = "DateOfNotification", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String dateOfNotification;

    @XmlElement(name = "SenCitizenApplicableDate", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String senCitizenApplicableDate;

    @XmlElement(name = "SeniorCitizen", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String seniorCitizen;

    @XmlElement(name = "CustStatus", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String custStatus;

    @XmlElement(name = "PhysicalState", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String physicalState;

    @XmlElement(name = "AadhaarNumber", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String aadhaarNumber;

    @XmlElement(name = "StaffEmployeeID", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String staffEmployeeID;

    @XmlElement(name = "RiskProfileScore", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String riskProfileScore;

    @XmlElement(name = "submitForKYC", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String submitForKYC;

    @XmlElement(name = "KYC_ReviewDate", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String kycReviewDate;

}
