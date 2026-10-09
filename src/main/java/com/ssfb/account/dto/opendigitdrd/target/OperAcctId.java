package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class OperAcctId {
    @XmlElement(name = "AcctId", namespace = "http://www.finacle.com/fixml")
    private String acctId;

    @XmlElement(name = "AcctType", namespace = "http://www.finacle.com/fixml")
    private AcctType acctType;

    @XmlElement(name = "AcctCurr", namespace = "http://www.finacle.com/fixml")
    private String acctCurr;

    @XmlElement(name = "BankInfo", namespace = "http://www.finacle.com/fixml")
    private BankInfo bankInfo;
}
