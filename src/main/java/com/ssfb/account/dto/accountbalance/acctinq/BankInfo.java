package com.ssfb.account.dto.accountbalance.acctinq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankInfo {
    @JsonProperty(value = "BankId")
    private String bankId;

    @JsonProperty(value = "Name")
    private String name;

    @JsonProperty(value = "BranchId")
    private String branchId;

    @JsonProperty(value = "BranchValue")
    private String branchValue;

    @JsonProperty(value = "PostAddress")
    private PostAddress postAddr;
}
