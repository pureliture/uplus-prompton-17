package com.vocboard.vocboardbackend.core.application;

import com.vocboard.vocboardbackend.core.dto.QABoardResponse;
import com.vocboard.vocboardbackend.core.entity.QABoardEntity;
import com.vocboard.vocboardbackend.core.mapper.QABoardMapper;
import com.vocboard.vocboardbackend.core.repository.QABoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QABoardQueryService {

    private final QABoardRepository qaBoardRepository;
    private final QABoardMapper qaBoardMapper;

    private final AdaAiLinkService adaAiLinkService;

    public QABoardResponse retrieveQABoardContent(String id) {

        return qaBoardMapper.toResponse(qaBoardRepository.findById(id).orElseGet(() -> QABoardEntity.builder().build()));
    }

    public List<QABoardResponse> retrieveQABoardContents(List<String> idList) {

        return qaBoardMapper.toResponseList(qaBoardRepository.findAllById(idList));
    }

    public List<QABoardResponse> retrieveMatchedQABoardContentsByAda(String question) {
        List<String> idList = adaAiLinkService.retrieveMatchedQAIdListByAda(question);
        return qaBoardMapper.toResponseList(qaBoardRepository.findAllById(idList));
    }

    public List<QABoardResponse> retrieveQABoardContentsAll() {

        return qaBoardMapper.toResponseList(qaBoardRepository.findAll());
    }

}
