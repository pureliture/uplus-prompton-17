package com.vocboard.vocboardbackend.core.application;

import com.vocboard.vocboardbackend.common.infrastructure.model.AzureGptApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdaAiLinkService {

    private final AzureGptApi azureGptApi;

    public List<String> retrieveMatchedQAIdListByAda(String question) {

        List<String> idList = azureGptApi.search(question);
        log.info("Response : {}", idList);

        return idList;
    }
}

