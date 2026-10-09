package com.ssfb.account.dto.opendigitdrd.target;
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
@XmlRootElement(name = "FIXML", namespace = "http://www.finacle.com/fixml")
@XmlAccessorType(XmlAccessType.FIELD)
public class FIXML {
    @XmlElement(name = "Header", namespace = "http://www.finacle.com/fixml" )
    public CommonHeaders header;

    @XmlElement (name = "Body", namespace = "http://www.finacle.com/fixml" )
    public Body body;

}
