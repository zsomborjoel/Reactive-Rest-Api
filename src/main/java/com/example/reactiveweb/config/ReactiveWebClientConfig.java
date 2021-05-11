package com.example.reactiveweb.config;

import static io.netty.channel.ChannelOption.CONNECT_TIMEOUT_MILLIS;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.reactiveweb.model.properties.ReactiveWebClientProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.netty.http.client.HttpClient;

@Configuration
@EnableConfigurationProperties(value = { ReactiveWebClientProperties.class })
public class ReactiveWebClientConfig {

    @Bean
    public WebClient getWebClient(ReactiveWebClientProperties reactiveWebClientProperties) {
        HttpClient httpClient = HttpClient.create()
                .tcpConfiguration(client ->
                        client.option(CONNECT_TIMEOUT_MILLIS, reactiveWebClientProperties.getConnectionTimeout())
                                .doOnConnected(conn -> conn
                                        .addHandlerLast(new ReadTimeoutHandler(reactiveWebClientProperties.getReadTimeout()))
                                        .addHandlerLast(new WriteTimeoutHandler(reactiveWebClientProperties.getWriteTimeout()))));

        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

        return WebClient.builder()
                .baseUrl(reactiveWebClientProperties.getBaseUrl())
                .clientConnector(connector)
                .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .build();
    }

}
