package com.vocboard.vocboardbackend.common.infrastructure.model;

import com.vocboard.vocboardbackend.core.dto.AdaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class AzureGptApi {

    private static final String URL = "https://fluffy-space-invention-5rjpjrx6545hpxwj-7390.app.github.dev/score";

    public List<String> search(String question) {

        String requestBody = "{\"question\":\"" + question + "\"}";

        // 검색어 인코딩
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, httpHeaders);

        ResponseEntity<AdaResponse> responseBody = new RestTemplate().exchange(
                URL, HttpMethod.POST, entity, AdaResponse.class);

        List<String> responseList = Objects.requireNonNull(responseBody.getBody()).getOutput();
        return responseList;
    }
}
