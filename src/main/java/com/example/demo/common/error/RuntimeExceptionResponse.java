package com.example.demo.common.error;


import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RuntimeExceptionResponse {
    private final String message;
    private  LocalDateTime time = LocalDateTime.now();
    private final int status;

    public static RuntimeExceptionResponse create(ErrorCode errorCode) {
        return new RuntimeExceptionResponse(errorCode.getMessage(),errorCode.getStatus().value());
    }
}
