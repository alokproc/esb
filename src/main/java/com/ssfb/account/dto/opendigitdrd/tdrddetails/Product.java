package com.ssfb.account.dto.opendigitdrd.tdrddetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public  class Product {
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Group")
    private String group;
    @JsonProperty("Class")
    private String clazz;
    @JsonProperty("Description")
    private String description;
}
