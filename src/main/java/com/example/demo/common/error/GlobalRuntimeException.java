package com.example.demo.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public class GlobalRuntimeException extends RuntimeException{
    private final ErrorCode errorCode;
}
