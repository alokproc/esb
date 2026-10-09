package com.ssfb.account.dto.opendigitdrd.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class InterestTransferAccount {

    @Size(min = 0, max = 20, message = "AccountId length must be between 0 and 20")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid AccountId")
    @JsonProperty("AccountId")
    private String accountId;
}
