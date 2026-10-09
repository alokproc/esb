package com.ssfb.account.dto.accountbalance.acctinq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerStatus {
    @JsonProperty(value = "ReferenceCode")
    private String refCode;

    @JsonProperty(value = "ReferenceRecType")
    private String refRecType;

    @JsonProperty(value = "ReferenceDescription")
    private String refDesc;
}
