package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class RenewalDtls {
    @XmlElement(name = "AutoCloseOnMaturityFlg", namespace = "http://www.finacle.com/fixml")
    private String autoCloseOnMaturityFlg;

    @XmlElement(name = "AutoRenewalflg", namespace = "http://www.finacle.com/fixml")
    private String autoRenewalflg;

    @XmlElement(name = "MaxNumOfRenewalAllwd", namespace = "http://www.finacle.com/fixml")
    private String maxNumOfRenewalAllwd;

    @XmlElement(name = "RenewalTerm", namespace = "http://www.finacle.com/fixml")
    private RenewalTerm renewalTerm;

    @XmlElement(name = "RenewalSchm", namespace = "http://www.finacle.com/fixml")
    private RenewalSchm renewalSchm;

    @XmlElement(name = "GenLedgerSubHead", namespace = "http://www.finacle.com/fixml")
    private GenLedgerSubHead genLedgerSubHead;

    @XmlElement(name = "IntTblCode", namespace = "http://www.finacle.com/fixml")
    private String intTblCode;

    @XmlElement(name = "RenewalCurCode", namespace = "http://www.finacle.com/fixml")
    private String renewalCurCode;

    @XmlElement(name = "RenewalOption", namespace = "http://www.finacle.com/fixml")
    private String renewalOption;

    @XmlElement(name = "RenewalAmt", namespace = "http://www.finacle.com/fixml")
    private RenewalAmt renewalAmt;
}
