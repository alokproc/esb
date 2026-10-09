package com.ssfb.account.dto.accountbalance.target.sbacct;

import com.ssfb.account.dto.accountbalance.common.AcctId;
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
public class SBAcctInqRq {
    @XmlElement(name = "SBAcctId", namespace = "http://www.finacle.com/fixml")
    private AcctId sbAcctId;
}
