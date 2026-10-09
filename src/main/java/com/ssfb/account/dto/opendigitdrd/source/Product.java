package com.ssfb.account.dto.opendigitdrd.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Product {

    @Pattern(regexp = "^[a-zA-Z0-9]*$" , message = "Invalid Type")
    @JsonProperty("Type")
    private String type;

}
