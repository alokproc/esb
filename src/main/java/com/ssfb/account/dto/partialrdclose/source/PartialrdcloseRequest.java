package com.ssfb.account.dto.partialrdclose.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PartialrdcloseRequest {

    @Valid
    @JsonProperty(value="Data")
    private PartialrdcloseRequestBody data;

}
