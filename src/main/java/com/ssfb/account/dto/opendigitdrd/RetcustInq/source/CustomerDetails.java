package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetails {

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

    @JsonProperty("MAIDENNAME")
    private String maidenName;

    @JsonProperty("PLACEOFBIRTH")
    private String placeOfBirth;

    @JsonProperty("NATIONALITY")
    private String nationality;

    @JsonProperty("RESIDENTIALSTATUS")
    private String residentialStatus;

    @JsonProperty("PARENTGUARDIANNAME")
    private String parentGuardianName;

    @JsonProperty("RELATIONSHIP")
    private String relationship;

    @JsonProperty("GUARDIANCIFNUMBER")
    private String guardianCifNumber;

    @JsonProperty("ADULTDEPENDENT")
    private String adultDependent;

    @JsonProperty("CHILDDEPENDENT")
    private String childDependent;

    @JsonProperty("COMPANYCIF")
    private String companyCif;

    @JsonProperty("EMPLOYEECODE")
    private String employeeCode;

    @JsonProperty("OCCUPATION")
    private String occupation;

    @JsonProperty("WORKINGCOMPANY")
    private String workingCompany;

    @JsonProperty("DESIGNATION")
    private String designation;

    @JsonProperty("WORKINGSINCE")
    private String workingSince;

    @JsonProperty("GROSSANNUALINCOME")
    private String grossAnnualIncome;

    @JsonProperty("BUSINESSNATURE")
    private String businessNature;

    @JsonProperty("ANNUALTURNOVER")
    private String annualTurnover;

    @JsonProperty("INCORPORATION_DATE")
    private String incorporationDate;

    @JsonProperty("BranchOwnerShip")
    private String branchOwnerShip;

    @JsonProperty("DIN")
    private String din;

    @JsonProperty("BARCODE")
    private String barcode;
    @JsonProperty("FORM60") private String form60;
    @JsonProperty("TAN") private String tan;
    @JsonProperty("UDYOGAADHAR") private String udyogAadhar;
    @JsonProperty("PLACE_OF_INCORPORATION") private String placeOfIncorporation;
    @JsonProperty("FATCACOMPLIANCE") private String fatcaCompliance;
    @JsonProperty("DateOfDeath") private String dateOfDeath;
    @JsonProperty("DateOfNotification") private String dateOfNotification;
    @JsonProperty("CUSTOMERCODE") private String customerCode;
    @JsonProperty("CUSTOMERRISKCODE") private String customerRiskCode;
    @JsonProperty("SBUCODE") private String sbuCode;
    @JsonProperty("SPOUSE_NAME") private String spouseName;
    @JsonProperty("DND") private String dnd;
    @JsonProperty("SMS_CUSTOMER") private String smsCustomer;
    @JsonProperty("ELECTRONIC_BILLPAYMENT") private String electronicBillPayment;
    @JsonProperty("MOBILE_BANKING") private String mobileBanking;
    @JsonProperty("NEW_CIF") private String newCif;
    @JsonProperty("ADDRESS_PROOF") private String addressProof;
    @JsonProperty("PHYSICALSTATUS") private String physicalStatus;
    @JsonProperty("EMPLOYEE_NAME") private String employeeName;
    @JsonProperty("INTERNET_ACCESS") private String internetAccess;
    @JsonProperty("SMS_REGISTRATION") private String smsRegistration;
    @JsonProperty("STATEMENTBYEMAIL") private String statementByEmail;
    @JsonProperty("HOBBIES") private String hobbies;
    @JsonProperty("POLITICALLYEXPOSED") private String politicallyExposed;

    @JsonProperty("NAME_OF_DOCUMENT") private String nameOfDocument;
    @JsonProperty("ISSUING_AUTHORITY") private String issuingAuthority;
    @JsonProperty("PLACE_OF_ISSUE") private String placeOfIssue;
    @JsonProperty("DATE_OF_COMMENCEMENT") private String dateOfCommencement;
    @JsonProperty("COUNTRY_OF_REGISTRATION") private String countryOfRegistration;
    @JsonProperty("DATE_OF_BOARD") private String dateOfBoard;
    @JsonProperty("NATURE_OF_ACTIVITY") private String natureOfActivity;
    @JsonProperty("CORPORATE_GROUP") private String corporateGroup;
    @JsonProperty("IBW_TAGGING") private String ibwTagging;
    @JsonProperty("EMAILSTMTFREQUENCY") private String emailStmtFrequency;

    @JsonProperty("TRADE_LICENSE") private String tradeLicense;
    @JsonProperty("SALES_TAX_NO") private String salesTaxNo;
    @JsonProperty("EXCISE_REGISTRATION") private String exciseRegistration;
    @JsonProperty("BSR4_LEVEL1") private String bsr4Level1;
    @JsonProperty("BSR4_LEVEL2") private String bsr4Level2;
    @JsonProperty("BSR4_LEVEL3") private String bsr4Level3;
    @JsonProperty("SSI_MSME_REGISTRATION") private String ssiMsmeRegistration;

    @JsonProperty("VISA_COUNTRY") private String visaCountry;
    @JsonProperty("VISA_DETAILS") private String visaDetails;
    @JsonProperty("VISAISSUEDATE") private String visaIssueDate;
    @JsonProperty("NRISINCE") private String nriSince;
    @JsonProperty("DBTCUSTOMER") private String dbtCustomer;
    @JsonProperty("VISA_EXPIRY") private String visaExpiry;
    @JsonProperty("VISA_ISSUE_BY") private String visaIssueBy;
    @JsonProperty("VISA_ISSUE_PLACE") private String visaIssuePlace;
    @JsonProperty("VISA_TYPE") private String visaType;
    @JsonProperty("VISA_NUMBER") private String visaNumber;

    @JsonProperty("NO_OF_INSURANCE") private String noOfInsurance;
    @JsonProperty("INSURANCE_TYPE") private String insuranceType;
    @JsonProperty("INSURANCE_COMPANY") private String insuranceCompany;

    @JsonProperty("OTHERBANK_ACCOUNT") private String otherBankAccount;
    @JsonProperty("LOAN_FROM_OTHERBANK") private String loanFromOtherBank;
    @JsonProperty("LOAN_BANKNAME") private String loanBankName;
    @JsonProperty("LOAN_EMI") private String loanEmi;
    @JsonProperty("TYPE_OF_LOAN") private String typeOfLoan;

    @JsonProperty("YEAR_OF_CURRENTADDRESS") private String yearOfCurrentAddress;
    @JsonProperty("MONTHLY_INCOME") private String monthlyIncome;
    @JsonProperty("SELF_EMPLOYEED_MONTH") private String selfEmployedMonth;
    @JsonProperty("SELF_EMPLOYEED_YEARS") private String selfEmployedYears;
    @JsonProperty("NET_WORTH") private String netWorth;

    @JsonProperty("KYC_TYPE") private String kycType;
    @JsonProperty("TDS_SLAB") private String tdsSlab;
    @JsonProperty("REKYC_FLAG") private String rekycFlag;
    @JsonProperty("FORM15G") private String form15g;
    @JsonProperty("FORM15H") private String form15h;

    @JsonProperty("LAT") private String latitude;
    @JsonProperty("LONG") private String longitude;
    @JsonProperty("LANGUAGE") private String language;

    @JsonProperty("AbusiveLanguage") private String abusiveLanguage;
    @JsonProperty("FaceMatchScore") private String faceMatchScore;
    @JsonProperty("NameMatchScore") private String nameMatchScore;
    @JsonProperty("AadharAndPanLinkStatus") private String aadharAndPanLinkStatus;
    @JsonProperty("LivelinessCheck") private String livelinessCheck;

    @JsonProperty("CustomerNetWorth") private String customerNetWorth;
    @JsonProperty("CustomerNetWorthCurrencyCode") private String customerNetWorthCurrencyCode;
    @JsonProperty("VpaID") private String vpaId;
    @JsonProperty("LineOfActivity") private String lineOfActivity;
    @JsonProperty("NatureOfActivity") private String natureOfActivity2;
    @JsonProperty("NetWorth") private String netWorth2;

    @JsonProperty("EmailAddressPresent") private String emailAddressPresent;
    @JsonProperty("ConstitutionCode") private String constitutionCode;
    @JsonProperty("TradeServicesAvailed") private String tradeServicesAvailed;

    @JsonProperty("AddressDetails")
    private AddressDetails addressDetails;

    @JsonProperty("KYCDetails")
    private KycDetails kycDetails;

    @JsonProperty("GSTDetails")
    private GstDetails gstDetails;
}

