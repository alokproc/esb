package com.ssfb.account.dto.opendigitdrd.source;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Amount {

    @Pattern(regexp = "\\d*" , message = "Invalid Amount")
    @JsonProperty("Amount")
    private String amount;

    @Pattern(regexp = "^[a-zA-Z0-9]*$" , message = "Invalid Type")
    @JsonProperty("Type")
    private String type;

    @Pattern(regexp = "^[a-zA-Z0-9]*$" , message = "Invalid CurrencyCode")
    @JsonProperty("CurrencyCode")
    private String currencyCode;
}
