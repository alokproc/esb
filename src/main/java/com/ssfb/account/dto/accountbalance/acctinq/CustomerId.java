package com.ssfb.account.dto.accountbalance.acctinq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerId {
    @JsonProperty(value = "CustomerId")
    private String customerId;

    @JsonProperty(value = "PersonName")
    private PersonName personName;
}
