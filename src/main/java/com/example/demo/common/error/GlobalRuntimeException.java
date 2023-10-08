package com.example.demo.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@RequiredArgsConstructor
@Getter
public class GlobalRuntimeException extends RuntimeException{
    private final ErrorCode errorCode;

    public HttpStatus getStatus() {
        return errorCode.getStatus();
    }
}
