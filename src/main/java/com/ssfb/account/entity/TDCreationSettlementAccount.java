package com.ssfb.account.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Settlement_Account")
@Data
public class TDCreationSettlementAccount {

    @Column(name = "Channel_Name")
    private String channelName;

    @Column(name = "Settlement_dr_leg")
    private String settlementDebitLeg;

    @Column(name = "Settlement_cr_leg")
    private String settlementCreditLeg;

    @Id
    @Column(name = "account_id")
    private String accountId;

}
