package com.ssfb.account.dto.accountbalance.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Relparty {

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Code")
    private String code;

    @JsonProperty("CustomerId")
    private String customerId;

    @JsonProperty("Age")
    private String age;

    @JsonProperty("RecordDeleteFlag")
    private String recordDeleteFlag;

}
