package com.vocboard.vocboardbackend.core.mapper;

import com.vocboard.vocboardbackend.core.dto.QABoardResponse;
import com.vocboard.vocboardbackend.core.entity.QABoardEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QABoardMapper {

    QABoardResponse toResponse(QABoardEntity qaBoardEntity);
    List<QABoardResponse> toResponseList(List<QABoardEntity> qaBoardEntities);
}
