package com.vocboard.vocboardbackend.core.application;

import com.vocboard.vocboardbackend.common.infrastructure.model.AzureGptApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdaAiLinkService {

    private final WebClient webClient;
    private final AzureGptApi azureGptApi;

    public List<String> retrieveMatchedQAIdListByAda(String question) {

//        // 요청할 API의 URL
//        String apiUrl = "https://fluffy-space-invention-5rjpjrx6545hpxwj-7390.app.github.dev/score";
//
//        // 요청 바디 데이터 (JSON 형태로 예시)
//        String requestBody = "{\"question\":\"" + question + "\"}";
//
//        // 요청 헤더 설정
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        // POST 요청 보내기
//        Mono<List<String>> responseListMono = webClient.post()
//                .uri(apiUrl)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(requestBody))
//                .retrieve()
//                .bodyToFlux(String.class)  // Flux<String>로 응답 받기
//                .collectList();  // Flux를 List로 변환
//
//        responseListMono.subscribe(result -> log.info("Result : {}", result));
//
//        // 사용 예시: 응답을 블로킹 방식으로 출력(비추천, 예시용)
//        List<String> responseList = responseListMono.block();
//        log.info("Response : {}", responseList);

        List<String> idList = azureGptApi.search(question);
        log.info("Response : {}", idList);

        return idList;
    }
}

