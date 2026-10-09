package com.ssfb.account.dto.accountbalance.target.caacct;

import com.ssfb.commonmodule.dto.fixml.CommonHeaders;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "FIXML", namespace = "http://www.finacle.com/fixml")
public class FIXML {
    @XmlElement(name = "Header", namespace = "http://www.finacle.com/fixml")
    private CommonHeaders header;

    @XmlElement(name = "Body", namespace = "http://www.finacle.com/fixml")
    public Body body;
}
