package com.ssfb.account.dto.opendigitdrd.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssfb.account.dto.Error;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TDRDCreateResponse {

    @JsonProperty("Data")
    private List<TDRDCreateResponseBody> tDRDCreateResponseBody;

    @JsonProperty("Error")
    private Error error;


}
