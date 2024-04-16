package com.vocboard.vocboardbackend.core.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
public class QABoardResponse {

    private Long id;
    private String product;
    private String questionType;
    private String question;
    private String answer;
}
