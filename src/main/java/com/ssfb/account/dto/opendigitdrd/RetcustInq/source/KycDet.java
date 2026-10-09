package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KycDet {

    @JsonProperty("CIFNUMBER")
    private String cifNumber;

    @JsonProperty("DOCUMENTTYPE")
    private String documentType;

    @JsonProperty("DOCUMENTNUMBER")
    private String documentNumber;

    @JsonProperty("ISSUEDATE")
    private String issueDate;

    @JsonProperty("EXPIRYDATE")
    private String expiryDate;
}
