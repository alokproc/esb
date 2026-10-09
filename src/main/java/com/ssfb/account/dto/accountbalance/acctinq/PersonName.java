package com.ssfb.account.dto.accountbalance.acctinq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonName {
    @JsonProperty(value = "LastName")
    private String lastName;

    @JsonProperty(value = "FirstName")
    private String firstName;

    @JsonProperty(value = "MiddleName")
    private String middleName;

    @JsonProperty(value = "Name")
    private String name;

    @JsonProperty(value = "TitlePrefix")
    private String titlePrefix;
}
