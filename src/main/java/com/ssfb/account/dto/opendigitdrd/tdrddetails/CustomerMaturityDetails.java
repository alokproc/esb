package com.ssfb.account.dto.opendigitdrd.tdrddetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssfb.account.dto.helper.PostalAddress2;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CustomerMaturityDetails {
    @JsonProperty("MaturityDate")
    private String maturityDate;
    @JsonProperty("MaturityAmount")
    private String maturityAmount;
    @JsonProperty("DailyInvestment")
    private String dailyInvestment;
    @JsonProperty("NumberOfDays")
    private String numberOfDays;
    @JsonProperty("NumbnerOfMonths")
    private String numberOfMonths;
    @JsonProperty("GoalID")
    private String goalId;
    @JsonProperty("GoalName")
    private String goalName;
}
