package com.ssfb.account.dto.fetchutrdetails.source;

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
public class FetchUtrDetailsSourceResponseBody {

    @JsonProperty(value = "TransactionCode")
    private String transactionCode;

    @JsonProperty(value = "tran_amt")
    private String tranAmount;

    @JsonProperty(value = "SENDER_BIC")
    private String senderBic;

    @JsonProperty(value = "PAYSYS_ID")
    private String paysysId;

    @JsonProperty(value = "LCHG_TIME")
    private String lchgTime;

    @JsonProperty(value = "STATUS")
    private String status;

    @JsonProperty(value = "REASON")
    private String reason;

    @JsonProperty(value = "ORD_PARTY_ACCT")
    private String ordPartyAccount;

    @JsonProperty(value = "ORD_PARTY_NAME")
    private String ordPartyName;
}
