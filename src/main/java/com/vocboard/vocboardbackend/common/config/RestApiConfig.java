package com.vocboard.vocboardbackend.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;


@Configuration
public class RestApiConfig {

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

    // WebClient.Builder를 Bean으로 등록합니다.
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    // WebClient 인스턴스를 Bean으로 등록합니다.
    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        // WebClient의 기본 타임아웃 설정
        HttpClient httpClient = HttpClient.create().responseTimeout(Duration.ofSeconds(30));

        // ReactorClientHttpConnector를 사용하여 WebClient 빌드
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
