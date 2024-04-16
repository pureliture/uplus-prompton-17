package com.vocboard.vocboardbackend.core.application;

import com.vocboard.vocboardbackend.core.dto.QABoardResponse;
import com.vocboard.vocboardbackend.core.entity.QABoardEntity;
import com.vocboard.vocboardbackend.core.mapper.QABoardMapper;
import com.vocboard.vocboardbackend.core.repository.QABoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        List<QABoardEntity> qaBoardEntityList = qaBoardRepository.findAllById(idList);

        // idList의 각 ID에 대해 인덱스를 매핑합니다.
        Map<String, Integer> idOrder = new HashMap<>();
        for (int i = 0; i < idList.size(); i++) {
            idOrder.put(idList.get(i), i);
        }

        // 가져온 리스트를 idList의 순서대로 정렬합니다.
        List<QABoardEntity> sortedList = qaBoardEntityList.stream()
                .sorted(Comparator.comparingInt(entity -> idOrder.get(entity.getId())))
                .collect(Collectors.toList());

        return qaBoardMapper.toResponseList(sortedList);
    }

    public List<QABoardResponse> retrieveQABoardContentsAll() {

        return qaBoardMapper.toResponseList(qaBoardRepository.findAll());
    }

}
