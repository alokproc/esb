package com.ssfb.account.dto.loanstatement.target;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class ExecuteFinacleScriptCustomData {
    @XmlElement(name = "fromDate", namespace = "http://www.finacle.com/fixml")
    private String fromDate;

    @XmlElement(name = "toDate", namespace = "http://www.finacle.com/fixml")
    private String toDate;

    @XmlElement(name = "accId", namespace = "http://www.finacle.com/fixml")
    private String accountId;

    @XmlElement(name = "type", namespace = "http://www.finacle.com/fixml")
    private String type;

    @XmlElement(name = "InstantFileRequired", namespace = "http://www.finacle.com/fixml")
    private String instantFileRequired;

    @XmlElement(name = "FileFormat", namespace = "http://www.finacle.com/fixml")
    private String fileFormat;

    @XmlElement(name = "PasswordProtected", namespace = "http://www.finacle.com/fixml")
    private String passwordProtected;

    @XmlElement(name = "UPIRequired", namespace = "http://www.finacle.com/fixml")
    private String upiRequired;

    @XmlElement(name = "Base64String", namespace = "http://www.finacle.com/fixml")
    private List<String> base64String;

    @XmlElement(name = "ErrorDesc", namespace = "http://www.finacle.com/fixml")
    private String errorDesc;

}

