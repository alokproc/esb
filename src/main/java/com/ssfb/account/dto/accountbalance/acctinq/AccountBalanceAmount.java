package com.ssfb.account.dto.accountbalance.acctinq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountBalanceAmount {
    @JsonProperty(value = "AmountValue")
    private String amountValue;

    @JsonProperty(value = "CurrencyCode")
    private String currencyCode;
}