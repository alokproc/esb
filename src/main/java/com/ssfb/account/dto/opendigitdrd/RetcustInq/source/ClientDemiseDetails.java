package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDemiseDetails {

    @JsonProperty("IsDemised")
    private String isDemised;

    @JsonProperty("DeathDate")
    private String deathDate;

    @JsonProperty("NotificationDate")
    private String notificationDate;

    @JsonProperty("DocumentDtls")
    private DocumentDtls documentDtls;
}
