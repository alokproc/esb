package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstallmentFreq {

    @JsonProperty("InstFreqType")
    private String instFreqType;

    @JsonProperty("InstFreqStartDate")
    private String instFreqStartDate;

    @JsonProperty("InstFreqWeekDay")
    private String instFreqWeekDay;

    @JsonProperty("InstFreqWeekNum")
    private String instFreqWeekNum;

    @JsonProperty("InstFreqHolidayStatus")
    private String instFreqHolidayStatus;
}
