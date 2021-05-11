package com.example.reactiveweb.model.properties;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "web.reactive")
public class ReactiveWebClientProperties {

    @Value("${request.baseUrl:}")
    private String baseUrl;

    @Value("${request.connectionTimeoutMilli:10000}")
    private Integer connectionTimeout;

    @Value("${request.readTimeoutSec:10}")
    private Integer readTimeout;

    @Value("${request.writeTimeoutSec:10}")
    private Integer writeTimeout;

    @Value("${request.blockTimeout:10}")
    @DurationUnit(ChronoUnit.SECONDS)
    private Duration blockTimeout;

}
