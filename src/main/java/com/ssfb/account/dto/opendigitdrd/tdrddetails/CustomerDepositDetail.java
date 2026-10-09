package com.ssfb.account.dto.opendigitdrd.tdrddetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssfb.account.dto.helper.PostalAddress2;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CustomerDepositDetail {
    @JsonProperty("Dep_AccountNumber")
    private String depAccountNumber;
    @JsonProperty("Dep_Amount")
    private String depAmount;
    @JsonProperty("Dep_Maturity_Amount")
    private String depMaturityAmount;
    @JsonProperty("Opn_Effective_Date")
    private String opnEffectiveDate;
    @JsonProperty("Dep_Maturity_Date")
    private String depMaturityDate;
}
