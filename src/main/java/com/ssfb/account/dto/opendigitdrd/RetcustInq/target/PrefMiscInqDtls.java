package com.ssfb.account.dto.opendigitdrd.RetcustInq.target;
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
public class PrefMiscInqDtls {
    @XmlElement(name = "MiscellaneousID", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String miscellaneousId;

    @XmlElement(name = "dbFloat1", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String dbFloat1;

    @XmlElement(name = "dbFloat2", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String dbFloat2;

    @XmlElement(name = "dbFloat3", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String dbFloat3;

    @XmlElement(name = "dbFloat4", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String dbFloat4;

    @XmlElement(name = "dbFloat5", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String dbFloat5;

    @XmlElement(name = "dtDate1", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String dtDate1;

    @XmlElement(name = "strText10", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String strText10;

    @XmlElement(name = "Type", namespace = "http://www.finacle.com/fixml", nillable = true)
    private String type;
}
