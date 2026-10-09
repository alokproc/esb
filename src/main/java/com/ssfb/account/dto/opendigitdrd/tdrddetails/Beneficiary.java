package com.ssfb.account.dto.opendigitdrd.tdrddetails;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssfb.account.dto.helper.PostalAddress2;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Beneficiary {
    @JsonProperty("AccountId")
    private String accountId;
    @JsonProperty("IFSC")
    private String ifsc;
}
