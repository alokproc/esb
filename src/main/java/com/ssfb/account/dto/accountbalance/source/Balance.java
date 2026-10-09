package com.ssfb.account.dto.accountbalance.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Balance {
    @JsonProperty("Amount")
    private String amount;

    @JsonProperty("Currency")
    private String currency;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("CreditDebitFlag")
    private String creditDebitFlag;
}
