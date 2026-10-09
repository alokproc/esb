package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GstDetails {

    @JsonProperty("CIFNUMBER")
    private String cifNumber;

    @JsonProperty("GSTIN")
    private String gstIn;
}
