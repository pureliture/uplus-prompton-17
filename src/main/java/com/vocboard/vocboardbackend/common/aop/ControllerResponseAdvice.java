package com.vocboard.vocboardbackend.common.aop;

import com.vocboard.vocboardbackend.common.response.SuccessResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = "com.vocboard")
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public ResponseEntity<Object> beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                                  org.springframework.http.server.ServerHttpRequest request,
                                                  ServerHttpResponse response) {

        return ResponseEntity.ok().body(SuccessResponse.of(body));
    }
}
