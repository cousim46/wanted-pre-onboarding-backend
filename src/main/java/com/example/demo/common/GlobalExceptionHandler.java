package com.example.demo.common;

import com.example.demo.common.error.ErrorCode;
import com.example.demo.common.error.GlobalRuntimeException;
import com.example.demo.common.error.RuntimeExceptionResponse;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String,String> validate(MethodArgumentNotValidException e) {
        Map<String, String> response = new HashMap<>();
        e.getAllErrors().forEach(error ->
            response.put(((FieldError) error).getField(), error.getDefaultMessage())
            );
        return response;
    }

    @ExceptionHandler({GlobalRuntimeException.class})
    public static ResponseEntity<RuntimeExceptionResponse> response(ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getStatus())
            .body(RuntimeExceptionResponse.create(errorCode));
    }
}

