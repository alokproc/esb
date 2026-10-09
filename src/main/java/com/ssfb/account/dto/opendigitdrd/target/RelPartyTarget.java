package com.ssfb.account.dto.opendigitdrd.target;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class RelPartyTarget {
    @XmlElement(name = "PASSSHEETFLG", namespace = "http://www.finacle.com/fixml")
    private String passSheetFlg;

    @XmlElement(name = "LOANODNOTICEFLG", namespace = "http://www.finacle.com/fixml")
    private String loanOdNoticeFlg;

    @XmlElement(name = "XCLUDECOMBSTMTFLG", namespace = "http://www.finacle.com/fixml")
    private String xcludeCombStmtFlg;

    @XmlElement(name = "SIFLG", namespace = "http://www.finacle.com/fixml")
    private String siFlg;

    @XmlElement(name = "DEPOSITNOTICEFLG", namespace = "http://www.finacle.com/fixml")
    private String depositNoticeFlg;

    @XmlElement(name = "CIFID", namespace = "http://www.finacle.com/fixml")
    private String cifId;

    @XmlAttribute(name = "isMultiRec")
    private String isMultiRec;
}
