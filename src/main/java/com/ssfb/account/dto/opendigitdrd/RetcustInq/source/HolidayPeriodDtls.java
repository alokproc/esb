package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HolidayPeriodDtls {

    @JsonProperty("HolidayPeriod")
    private String holidayPeriod;

    @JsonProperty("AutoRescheduleType")
    private String autoRescheduleType;

    @JsonProperty("HolidayInterestFlag")
    private String holidayInterestFlag;

    @JsonProperty("HolidayPeriodIntAmt")
    private String holidayPeriodIntAmt;

    @JsonProperty("InstFreqHolidayStatus")
    private String instFreqHolidayStatus;
}
