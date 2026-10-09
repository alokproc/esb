package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CRMCustDataResponse {
    @JsonProperty("CIFNo")
    private String cifNo;

    @JsonProperty("CustType")
    private String custType;

    @JsonProperty("BranchCode")
    private String branchCode;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("MiddleName")
    private String middleName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("IsMinor")
    private String isMinor;

    @JsonProperty("EmailId")
    private String emailId;

    @JsonProperty("DateOfBirth")
    private String dateOfBirth;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("RegisteredMobile")
    private String registeredMobile;

    @JsonProperty("PANNumber")
    private String panNumber;

    @JsonProperty("AadharRefNo")
    private String aadharRefNo;

    @JsonProperty("ReKYCDate")
    private String reKycDate;

    @JsonProperty("LastKYCDate")
    private String lastKycDate;

    @JsonProperty("GENDER")
    private String gender;

    @JsonProperty("MARITALSTATUS")
    private String maritalStatus;

    @JsonProperty("EDUCATION")
    private String education;

    @JsonProperty("RELIGION")
    private String religion;

    @JsonProperty("CASTE")
    private String caste;

    @JsonProperty("FATHERNAME")
    private String fatherName;

    @JsonProperty("MOTHERMAINDENNAME")
    private String motherMaidenName;

    @JsonProperty("PLACEOFBIRTH")
    private String placeOfBirth;

    @JsonProperty("NATIONALITY")
    private String nationality;

    @JsonProperty("RESIDENTIALSTATUS")
    private String residentialStatus;

    @JsonProperty("OCCUPATION")
    private String occupation;

    @JsonProperty("DESIGNATION")
    private String designation;

    @JsonProperty("WORKINGSINCE")
    private String workingSince;

    @JsonProperty("GROSSANNUALINCOME")
    private String grossAnnualIncome;

    @JsonProperty("CUSTOMERCODE")
    private String customerCode;

    @JsonProperty("CUSTOMERRISKCODE")
    private String customerRiskCode;

    @JsonProperty("SMS_CUSTOMER")
    private String smsCustomer;

    @JsonProperty("MOBILE_BANKING")
    private String mobileBanking;

    @JsonProperty("INTERNET_ACCESS")
    private String internetAccess;

    @JsonProperty("POLITICALLYEXPOSED")
    private String politicallyExposed;

    @JsonProperty("KYC_TYPE")
    private String kycType;

    @JsonProperty("REKYC_FLAG")
    private String rekycFlag;

    @JsonProperty("LANGUAGE")
    private String language;

    @JsonProperty("AbusiveLanguage")
    private String abusiveLanguage;

    @JsonProperty("FaceMatchScore")
    private String faceMatchScore;

    @JsonProperty("NameMatchScore")
    private String nameMatchScore;

    @JsonProperty("AadharAndPanLinkStatus")
    private String aadharAndPanLinkStatus;

    @JsonProperty("LivelinessCheck")
    private String livelinessCheck;

    @JsonProperty("CustomerNetWorth")
    private String customerNetWorth;

    @JsonProperty("CustomerNetWorthCurrencyCode")
    private String customerNetWorthCurrencyCode;

    @JsonProperty("VpaID")
    private String vpaId;

    @JsonProperty("LineOfActivity")
    private String lineOfActivity;

    @JsonProperty("NatureOfActivity")
    private String natureOfActivity;

    @JsonProperty("NetWorth")
    private String netWorth;

    @JsonProperty("EmailAddressPresent")
    private String emailAddressPresent;

    @JsonProperty("ConstitutionCode")
    private String constitutionCode;

    @JsonProperty("TradeServicesAvailed")
    private String tradeServicesAvailed;

    @JsonProperty("AddressDetails")
    private AddressDetails addressDetails;

    @JsonProperty("KYCDetails")
    private KycDetails kycDetails;

    @JsonProperty("GSTDetails")
    private GstDetails gstDetails;
}
