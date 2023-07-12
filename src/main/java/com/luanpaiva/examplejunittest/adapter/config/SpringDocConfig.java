package com.luanpaiva.examplejunittest.adapter.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringDocConfig {

    private final ApplicationProperties properties;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(properties.getName())
                        .description(properties.getDescription())
                        .version(properties.getVersion())
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org/")));
    }
}
