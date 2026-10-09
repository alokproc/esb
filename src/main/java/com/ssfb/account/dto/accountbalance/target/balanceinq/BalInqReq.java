package com.ssfb.account.dto.accountbalance.target.balanceinq;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "BalanceEnquiryFileElements", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
@XmlAccessorType(XmlAccessType.FIELD)
public class BalInqReq {
    @XmlElement(name = "sys_time", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
    private String sysTime;

    @XmlElement(name = "account_id", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
    private String accountId;

    @XmlElement(name = "avl_bal", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
    private String avlBal;

    @XmlElement(name = "user_id", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
    private String userId;

    @XmlElement(name = "cust_id", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
    private String custId;

    @XmlElement(name = "branch_id", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
    private String branchId;

    @XmlElement(name = "channel", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
    private String channel;

    @XmlElement(name = "card_no", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
    private String cardNo;

    @XmlElement(name = "last_txn_date", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
    private String lastTxnDate;

    @XmlElement(name = "insertion_date", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
    private String insertionDate;

    @XmlElement(name = "addEntity1", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
    private String addEntity1;

    @XmlElement(name = "addEntity2", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
    private String addEntity2;

    @XmlElement(name = "addEntity3", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
    private String addEntity3;

    @XmlElement(name = "addEntity4", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
    private String addEntity4;

    @XmlElement(name = "addEntity5", namespace = "http://www.suryoday.com/BankBatchProcessor/References/BalanceEnquiry/v1")
    private String addEntity5;

}
