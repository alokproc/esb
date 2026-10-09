package com.ssfb.account.dto.accountbalance.acctinq;

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
public class AcctInqSourceResponseBody {
    @JsonProperty(value = "AccountId")
    private AccountId accountId;

    @JsonProperty(value = "CustomerId")
    private CustomerId customerId;

    @JsonProperty(value = "AccountOpenDate")
    private String accountOpenDate;

    @JsonProperty(value = "BankAccountStatusCode")
    private String bankAccountStatusCode;

    @JsonProperty(value = "AccountBalance")
    private List<AccountBalance> accountBalance;

    @JsonProperty(value = "CustomerStatus")
    private List<CustomerStatus> customerStatus;

    @JsonProperty(value = "AccountCloseFlag")
    private String accountCloseFlag;

    @JsonProperty(value = "AvailableBalanceFlag")
    private String availableBalanceFlag;

    @JsonProperty(value = "LedgerBalanceFlag")
    private String ledgerBalanceFlag;

    @JsonProperty(value = "EffectiveBalanceFlag")
    private String effectiveBalanceFlag;
}
