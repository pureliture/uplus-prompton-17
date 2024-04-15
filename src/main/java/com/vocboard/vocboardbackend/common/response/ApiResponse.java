package com.vocboard.vocboardbackend.common.response;

public sealed interface ApiResponse permits SuccessResponse, FailResponse {

    String DEFAULT_API_VERSION = "1.0.0";

    String getApiVersion();

    boolean isSuccess();
}
