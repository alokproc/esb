package com.ssfb.account.dto.loanstatement.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanAccountStatementRequest {

    @Valid
    @NotNull(message = "The Data is required.")
    @JsonProperty(value = "Data")
    public LoanAccountStatementRequestBody data;
}
