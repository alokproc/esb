package com.ssfb.account.dto.opendigitdrd.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Agent {

    @JsonProperty("AgentID")
    private String agentID;

    @JsonProperty("AgentLatLong")
    private String agentLatLong;
}
