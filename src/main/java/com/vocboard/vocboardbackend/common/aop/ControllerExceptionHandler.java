package com.vocboard.vocboardbackend.common.aop;

import com.vocboard.vocboardbackend.common.exception.NoPostException;
import com.vocboard.vocboardbackend.common.response.FailResponse;
import com.vocboard.vocboardbackend.common.response.code.ApiNoContentsCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NoPostException.class)
    public ResponseEntity<FailResponse> handleNoImageException(FailResponse failResponse) {

        return ResponseEntity.ok(FailResponse.of(new ApiNoContentsCode(), "요청하신 이미지가 존재하지 않습니다."));
    }
}
