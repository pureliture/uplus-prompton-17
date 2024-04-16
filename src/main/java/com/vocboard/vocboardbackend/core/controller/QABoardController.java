package com.vocboard.vocboardbackend.core.controller;

import com.vocboard.vocboardbackend.core.application.AdaAiLinkService;
import com.vocboard.vocboardbackend.core.application.QABoardQueryService;
import com.vocboard.vocboardbackend.core.dto.QABoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QABoardController {

    private final QABoardQueryService qaBoardQueryService;
    private final AdaAiLinkService adaAiLinkService;

    @GetMapping("/qaboard/{id}")
    public QABoardResponse retrieveQABoardContent(@PathVariable Long id) {

        return qaBoardQueryService.retrieveQABoardContent(id);
    }

    @PostMapping("/qaboard")
    public List<QABoardResponse> retrieveQABoardContentList(@RequestBody List<Long> idList) {

        return qaBoardQueryService.retrieveQABoardContents(idList);
    }

    @GetMapping("/qaboard")
    public List<QABoardResponse> retrieveQABoardContentsAll() {

        return qaBoardQueryService.retrieveQABoardContentsAll();
    }

    @GetMapping("/qaboard/ada/")
    public List<QABoardResponse> retrieveMostMatchedQuestionList(String question) {

        return qaBoardQueryService.retrieveMatchedQABoardContentsByAda(question);
    }
}
