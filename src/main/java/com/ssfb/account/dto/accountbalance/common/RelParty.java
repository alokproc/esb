package com.ssfb.account.dto.accountbalance.common;

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
public class RelParty {
    @XmlElement(name = "CIFID", namespace = "http://www.finacle.com/fixml")
    private String cifId;

    @XmlElement(name = "DEPOSITNOTICEFLG", namespace = "http://www.finacle.com/fixml")
    private String depositNoticeFlg;

    @XmlElement(name = "LOANODNOTICEFLG", namespace = "http://www.finacle.com/fixml")
    private String loanOdNoticeFlg;

    @XmlElement(name = "PASSSHEETFLG", namespace = "http://www.finacle.com/fixml")
    private String passSheetFlg;

    @XmlElement(name = "SIFLG", namespace = "http://www.finacle.com/fixml")
    private String siFlg;

    @XmlElement(name = "XCLUDECOMBSTMTFLG", namespace = "http://www.finacle.com/fixml")
    private String xcludeCombStmtFlg;
}
