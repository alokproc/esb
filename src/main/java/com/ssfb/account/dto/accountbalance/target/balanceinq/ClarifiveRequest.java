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
public class ClarifiveRequest {

    @JsonProperty("PayLoad")
    private String payload;

    @JsonProperty("EventID")
    private String eventId;

    @JsonProperty("EventTS")
    private long eventTs;

    @JsonProperty("EntityID")
    private String entityId;
}
