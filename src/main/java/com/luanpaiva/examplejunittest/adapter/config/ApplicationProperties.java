package com.luanpaiva.examplejunittest.adapter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(value = "app.info")
public class ApplicationProperties {

    private String name;
    private String description;
    private String version;
}
