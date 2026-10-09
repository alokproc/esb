package com.ssfb.account.dto.opendigitdrd.tdrddetails;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssfb.commonmodule.dto.Error;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TDRDDetailsResponse {

    @JsonProperty(value ="Data")
    private TDRDDetailsResponseBody data;

    @JsonProperty("Error")
    private Error error;

}
