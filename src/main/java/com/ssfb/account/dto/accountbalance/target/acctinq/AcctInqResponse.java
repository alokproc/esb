package com.ssfb.account.dto.accountbalance.target.acctinq;

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
public class AcctInqResponse {
    @XmlElement(name = "AcctInqRs", namespace = "http://www.finacle.com/fixml")
    private AcctInqRs acctInqRs;

    @XmlElement(name = "AcctInq_CustomData", namespace = "http://www.finacle.com/fixml")
    private AcctInqCustomData acctInqCustomData;
}
