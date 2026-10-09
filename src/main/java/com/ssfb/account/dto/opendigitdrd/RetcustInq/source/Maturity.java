package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Maturity {
    @JsonProperty("Value")
    private String value;

    @JsonProperty("Date")
    private String date;

    @JsonProperty("DisbursementOption")
    private String disbursementOption;

    @JsonProperty("TransferAccountId")
    private String transferAccountId;

    @JsonProperty("Principal")
    private Principal principal;
}
