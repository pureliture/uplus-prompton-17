package com.vocboard.vocboardbackend.core.controller;

import com.vocboard.vocboardbackend.core.application.QABoardCommandService;
import com.vocboard.vocboardbackend.core.application.QABoardQueryService;
import com.vocboard.vocboardbackend.core.dto.QABoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QABoardController {

    private final QABoardQueryService qaBoardQueryService;
    private final QABoardCommandService qaBoardCommandService;

    @GetMapping("/qaboard/{id}")
    public QABoardResponse retrieveQABoardContent(@PathVariable Long id) {

        return qaBoardQueryService.retrieveQABoardContent(id);
    }

    @GetMapping("/qaboard")
    public List<QABoardResponse> retrieveQABoardContentsAll() {

        return qaBoardQueryService.retrieveQABoardContentsAll();
    }
}
