package com.ssfb.account.dto.loanstatement.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanAccountStatementResponseBody {

    @JsonProperty(value = "TransactionCode")
    private String transactionCode;

    @JsonProperty(value = "Base64String")
    private List<String> base64String;

}
