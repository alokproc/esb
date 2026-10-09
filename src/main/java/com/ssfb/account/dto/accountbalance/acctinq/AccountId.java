package com.ssfb.account.dto.accountbalance.acctinq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountId {
    @JsonProperty(value = "AccountId")
    private String accountId;

    @JsonProperty(value = "AccountType")
    private AccountType accountType;

    @JsonProperty(value = "AccountCurrency")
    private String accountCurrency;

    @JsonProperty(value = "BankInfo")
    private BankInfo bankInfo;
}
