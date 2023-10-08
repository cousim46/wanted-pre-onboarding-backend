package com.example.demo.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NOT_FOUND_ACCOUNT(HttpStatus.NOT_FOUND, "회원이 존재하지 않습니다."),
    NOT_FOUND_COMPANY(HttpStatus.NOT_FOUND,"회사가 존재하지 않습니다."),
    NOT_FOUND_ANNOUNCEMENT(HttpStatus.NOT_FOUND,"채용공고가 존재하지 않습니다."),

    ALREADY_REGISTER(HttpStatus.CONFLICT, "이미 신청한 채용 공고입니다.");
    private final HttpStatus status;
    private final String message;
}
