package com.ssfb.account.dto.opendigitdrd.tdrddetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TDRDDetailsResponseBody {

    @JsonProperty("Account")
    private List<Account> account;

    @JsonProperty("TransactionCode")
    private String transactionCode;


    

}
