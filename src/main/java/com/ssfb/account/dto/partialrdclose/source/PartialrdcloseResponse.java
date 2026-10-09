package com.ssfb.account.dto.partialrdclose.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssfb.account.dto.Error;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartialrdcloseResponse {

    @JsonProperty(value = "Data")
    private PartialrdcloseResponseBody data;

    @JsonProperty(value = "Error")
    private Error error;
}
