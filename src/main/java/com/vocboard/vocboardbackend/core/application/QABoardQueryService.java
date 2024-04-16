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

    public QABoardResponse retrieveQABoardContent(Long id) {

        return qaBoardMapper.toResponse(qaBoardRepository.findById(id).orElseGet(() -> QABoardEntity.builder().build()));
    }

    public List<QABoardResponse> retrieveQABoardContentsAll() {

        return qaBoardMapper.toResponseList(qaBoardRepository.findAll());
    }

}
