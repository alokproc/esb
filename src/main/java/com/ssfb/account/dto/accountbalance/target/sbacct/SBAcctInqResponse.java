package com.ssfb.account.dto.accountbalance.target.sbacct;

import com.ssfb.account.dto.accountbalance.common.AcctInqCustomData;
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
public class SBAcctInqResponse {
    @XmlElement(name = "SBAcctInqRs", namespace = "http://www.finacle.com/fixml")
    private SBAcctInqRs sbAcctInqRs;

    @XmlElement(name = "SBAcctInq_CustomData", namespace = "http://www.finacle.com/fixml")
    private AcctInqCustomData sbAcctInqCustomData;
}
