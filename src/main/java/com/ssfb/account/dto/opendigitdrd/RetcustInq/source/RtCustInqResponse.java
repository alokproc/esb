package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssfb.commonmodule.dto.Error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RtCustInqResponse {
    @JsonProperty(value = "Data")
    private RtCustInqResponseBody data;
    @JsonProperty(value = "Error")
    private Error error;

}
