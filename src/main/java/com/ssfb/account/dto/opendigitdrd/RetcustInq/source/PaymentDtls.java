package com.ssfb.account.dto.opendigitdrd.RetcustInq.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDtls {

    @JsonProperty("installmentFlg")
    private String installmentFlg;

    @JsonProperty("installmentType")
    private String installmentType;

    @JsonProperty("installmentFormula")
    private String installmentFormula;

    @JsonProperty("installmentId")
    private String installmentId;

    @JsonProperty("installmentStartDt")
    private String installmentStartDt;

    @JsonProperty("numOfInstallment")
    private String numOfInstallment;

    @JsonProperty("numOfAdvInstllment")
    private String numOfAdvInstllment;

    @JsonProperty("installmentFreq")
    private InstallmentFreq installmentFreq;

    @JsonProperty("holidayPeriodDtls")
    private HolidayPeriodDtls holidayPeriodDtls;

    @JsonProperty("InterestRestBasis")
    private String interestRestBasis;

    @JsonProperty("InterestRestFreq")
    private String interestRestFreq;
}
