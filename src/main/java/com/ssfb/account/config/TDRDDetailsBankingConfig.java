package com.ssfb.account.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "tdrddetailsbanking")
public class TDRDDetailsBankingConfig {
    private String Protocol;
    private String Hostname;
    private String Port;
    private String ResourcePath;
}
