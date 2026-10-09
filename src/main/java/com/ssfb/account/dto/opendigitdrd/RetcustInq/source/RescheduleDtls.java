package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RescheduleDtls {

    @JsonProperty("RescheduleType")
    private String rescheduleType;

    @JsonProperty("disburseFlg")
    private String disburseFlg;

    @JsonProperty("interestRateChange")
    private String interestRateChange;

    @JsonProperty("amountFlg")
    private String amountFlg;

    @JsonProperty("prePaymentFlg")
    private String prePaymentFlg;
}
