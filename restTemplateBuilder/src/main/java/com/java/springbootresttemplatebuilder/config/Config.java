package com.java.springbootresttemplatebuilder.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

import java.time.Duration;

@Configuration
public class Config {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler("http://localhost:8083/springDataJpa");
        return builder
                .uriTemplateHandler(uriTemplateHandler)
                .setReadTimeout(Duration.ofMillis(2000)) //set timeout in rest request
                .build();
    }
}