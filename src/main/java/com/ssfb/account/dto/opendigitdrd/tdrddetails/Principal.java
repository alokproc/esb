package com.ssfb.account.dto.opendigitdrd.tdrddetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Principal {
    @JsonProperty("DisbursementOption")
    private String disbursementOption;
    @JsonProperty("TransferAccountId")
    private String transferAccountId;
}
