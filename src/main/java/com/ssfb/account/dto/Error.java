package com.ssfb.account.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Error {

    @JsonProperty(value="Code")
    private String code;

    @JsonProperty(value="Description")
    private String description;
}
