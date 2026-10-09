package com.ssfb.account.dto.opendigitdrd.target;
import com.ssfb.commonmodule.dto.fixml.CommonError;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Body {
    @XmlElement(name = "TDAcctAddRequest", namespace = "http://www.finacle.com/fixml")
    private TDAcctAddRequest tdAcctAddRequest;

    @XmlElement(name = "TDAcctAddResponse", namespace = "http://www.finacle.com/fixml")
    private TDAcctAddResponse tdAcctAddResponse;

    @XmlElement(name = "Error", namespace = "http://www.finacle.com/fixml")
    private CommonError error;

}
