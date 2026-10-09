package com.ssfb.account.dto.fetchutrdetails.source;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FetchUtrDetailsSourceRequest {

    @JsonProperty(value = "Data")
    public FetchUtrDetailsSourceRequestBody data;
}
