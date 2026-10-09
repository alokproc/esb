package com.ssfb.account.util;

import com.ssfb.account.config.AccountConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class URIBuilderUtil {

    @Autowired
    private AccountConfig accountConfig;

    public URI accountURI(){
        return UriComponentsBuilder.newInstance().scheme(accountConfig.getProtocol()).host(accountConfig.getHostname())
                .port(accountConfig.getPort()).path(accountConfig.getPath()).build().toUri();
    }
}
