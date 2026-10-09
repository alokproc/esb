package com.ssfb.account.dto.loanstatement.source;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanAccountStatementRequestBody {


    @Pattern(regexp = "\\b(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])-\\d{4}\\b", message = "Invalid FromDate")
    @JsonProperty(value = "FromDate")
    private String fromDate;

    @Pattern(regexp = "\\b(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])-\\d{4}\\b", message = "Invalid ToDate")
    @JsonProperty(value = "ToDate")
    private String toDate;

    @Pattern(regexp = "^\\d{1,20}$", message = "Invalid AccountId")
    @JsonProperty(value = "AccountId")
    private String accountId;

    @Pattern(regexp = "^[0-9]{1,5}$", message = "Invalid Type")
    @JsonProperty(value = "Type")
    private String type;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid InstantFileRequired")
    @JsonProperty(value = "InstantFileRequired")
    private String instantFileRequired;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid FileFormat")
    @JsonProperty(value = "FileFormat")
    private String fileFormat;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid PasswordProtected")
    @JsonProperty(value = "PasswordProtected")
    private String passwordProtected;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid UPIRequired")
    @JsonProperty(value = "UPIRequired")
    private String upiRequired;

}
