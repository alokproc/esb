package com.ssfb.account.dto.opendigitdrd.RetcustInq.target;
import com.ssfb.commonmodule.dto.fixml.CommonError;
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
public class Body {
    @XmlElement(name = "RetCustInqRequest", namespace = "http://www.finacle.com/fixml", nillable = true)
    private RetCustInqRequest retCustInqRequest;
    @XmlElement(name = "RetCustInqResponse", namespace = "http://www.finacle.com/fixml", nillable = true)
    private RetCustInqResponse retCustInqResponse;
    @XmlElement(name = "Error", namespace = "http://www.finacle.com/fixml", nillable = true)
    private CommonError error;
}
