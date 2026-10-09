package com.ssfb.account.dto.fetchutrdetails.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssfb.account.dto.Error;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FetchUtrDetailsSourceResponse {

    @JsonProperty(value = "Data")
    public FetchUtrDetailsSourceResponseBody data;

    @JsonProperty(value = "Error")
    public Error error;
}
