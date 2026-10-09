package com.ssfb.account.dto.accountbalance.target.caacct;

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
public class CAAcctInqResponse {
    @XmlElement(name = "CAAcctInqRs", namespace = "http://www.finacle.com/fixml")
    private CAAcctInqRs caAcctInqRs;

    @XmlElement(name = "CAAcctInq_CustomData", namespace = "http://www.finacle.com/fixml")
    private AcctInqCustomData caAcctInqCustomData;
}
