package com.ssfb.account.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "accountbanking")
public class AccountConfig {
    private String protocol;
    private String hostname;
    private int port;
    private String path;
}
