package com.ssfb.account.repository;

import com.ssfb.account.entity.TDCreationSettlementAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TDCreationSettlementAccountRepository extends JpaRepository<TDCreationSettlementAccount, String> {


    @Query(value = "SELECT Channel_Name, Settlement_dr_leg, Settlement_cr_leg, account_id " +
            "FROM Settlement_Account WHERE Channel_Name = :channelName",
            nativeQuery = true)

    List<TDCreationSettlementAccount> findByChannelName(@Param("channelName") String channelName);

}
