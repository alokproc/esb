package com.ssfb.account.dto.accountbalance.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class BankInfo {
    @XmlElement(name = "BankId", namespace = "http://www.finacle.com/fixml")
    private String bankId;

    @XmlElement(name = "Name", namespace = "http://www.finacle.com/fixml")
    private String name;

    @XmlElement(name = "BranchId", namespace = "http://www.finacle.com/fixml")
    private String branchId;

    @XmlElement(name = "BranchName", namespace = "http://www.finacle.com/fixml")
    private String branchName;

    @XmlElement(name = "PostAddr", namespace = "http://www.finacle.com/fixml")
    private PostAddr postAddr;
}
