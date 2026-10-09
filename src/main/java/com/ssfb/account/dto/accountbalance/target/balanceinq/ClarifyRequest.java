package com.ssfb.account.dto.accountbalance.target.balanceinq;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClarifyRequest {
    @JsonProperty("eventtype")
    private String eventtype;

    @JsonProperty("eventsubtype")
    private String eventsubtype;

    @JsonProperty("eventname")
    private String eventname;

    @JsonProperty("event_id")
    private String eventId;

    @JsonProperty("source")
    private String source;

    @JsonProperty("eventts")
    private long eventts;

    @JsonProperty("msgBody")
    private String msgBody;
}
