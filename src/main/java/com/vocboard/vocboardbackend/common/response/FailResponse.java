package com.vocboard.vocboardbackend.common.response;

import com.vocboard.vocboardbackend.common.response.code.ApiResponseCode;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public non-sealed class FailResponse implements ApiResponse {

    private final String apiVersion;
    private final ApiResponseCode errorCode;
    private final String message;

    @Override
    public boolean isSuccess() {
        return false;
    }

    public static FailResponse of(ApiResponseCode errorCode, String message) {
        return FailResponse.builder()
                .apiVersion(DEFAULT_API_VERSION)
                .errorCode(errorCode)
                .message(message)
                .build();
    }
}
