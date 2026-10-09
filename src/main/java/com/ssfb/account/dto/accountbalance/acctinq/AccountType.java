package com.ssfb.account.dto.accountbalance.acctinq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountType {
    @JsonProperty(value = "SchemeCode")
    private String schemeCode;

    @JsonProperty(value = "SchemeType")
    private String schemeType;
}
