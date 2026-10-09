package com.ssfb.account.dto.rrninquiry.source;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RRNInquirySourceRequestBody {
    @JsonProperty(value = "Rrn")
    private String rrn;
}
