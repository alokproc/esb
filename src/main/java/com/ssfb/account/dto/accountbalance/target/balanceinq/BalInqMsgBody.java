package com.ssfb.account.dto.accountbalance.target.balanceinq;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BalInqMsgBody {
    @JsonProperty("host_id")
    private String hostId;

    @JsonProperty("sys_time")
    private String systemTime;

    @JsonProperty("event_id")
    private String eventId;

    @JsonProperty("account_id")
    private String accountId;

    @JsonProperty("avl_bal")
    private String availableBalance;

    @JsonProperty("branch_id")
    private String branchId;

    @JsonProperty("card_no")
    private String cardNumber;

    @JsonProperty("last_txn_date")
    private String lastTransactionDate;

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("cust_id")
    private String customerId;

    @JsonProperty("insertion_date")
    private String insertionDate;

    @JsonProperty("addentity1")
    private String additionalEntity1;

    @JsonProperty("addentity2")
    private String additionalEntity2;

    @JsonProperty("addentity3")
    private String additionalEntity3;

    @JsonProperty("addentity4")
    private String additionalEntity4;

    @JsonProperty("addentity5")
    private String additionalEntity5;
}
