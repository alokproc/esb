package com.ssfb.account.dto.accountbalance.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    @JsonProperty("Group")
    private String group;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Description")
    private String description;
}
