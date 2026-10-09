package com.ssfb.account.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "frm")
public class FrmConfig {
    private String protocol;
    private String hostname;
    private int port;
    private String path;
}
