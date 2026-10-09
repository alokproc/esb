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
public class PhoneEmailInfo {
    @XmlElement(name = "EmailInfo", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String emailInfo;

    @XmlElement(name = "EmailPalm", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String emailPalm;

    @XmlElement(name = "Email", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String email;

    @XmlElement(name = "PhoneEmailType", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String phoneEmailType;

    @XmlElement(name = "PhoneNum", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String phoneNum;

    @XmlElement(name = "PhoneNumCityCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String phoneNumCityCode;

    @XmlElement(name = "PhoneNumCountryCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String phoneNumCountryCode;

    @XmlElement(name = "PhoneNumLocalCode", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String phoneNumLocalCode;

    @XmlElement(name = "PhoneOrEmail", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String phoneOrEmail;

    @XmlElement(name = "PrefFlag", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String prefFlag;

    @XmlElement(name = "WorkExtnNum", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String workExtnNum;

    @XmlElement(name = "PhoneEmailID", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String phoneEmailID;
}

