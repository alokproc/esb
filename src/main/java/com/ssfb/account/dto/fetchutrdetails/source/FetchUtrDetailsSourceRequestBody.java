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
public class FetchUtrDetailsSourceRequestBody {


    @JsonProperty(value = "CHQ_NUMBER")
    private String chequeNumber;

    @JsonProperty(value = "UTR_NUMBER")
    private String utrNumber;

    @JsonProperty(value = "TRAN_DATE")
    private String tranDate;

}
