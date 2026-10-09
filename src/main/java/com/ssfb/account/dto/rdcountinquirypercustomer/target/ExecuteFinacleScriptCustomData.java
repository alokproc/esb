package com.ssfb.account.dto.rdcountinquirypercustomer.target;

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
public class ExecuteFinacleScriptCustomData {

    @XmlElement(name = "CUSTOMER_ID", namespace = "http://www.finacle.com/fixml")
    private String customerId;

    //Response

    @XmlElement(name = "MSG", namespace = "http://www.finacle.com/fixml")
    private String message = "";

    @XmlElement(name = "STATUS", namespace = "http://www.finacle.com/fixml")
    private String status;
}
