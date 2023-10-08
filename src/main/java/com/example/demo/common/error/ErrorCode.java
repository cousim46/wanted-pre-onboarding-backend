package com.example.demo.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * packageName    : com.example.demo.common.error
 * fileName       : ErrorCode
 * author         : jhw1015
 * date           : 2023/10/08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/10/08           jhw1015           최초 생성
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {

    NOT_FOUND_COMPANY(HttpStatus.NOT_FOUND,"회사가 존재하지 않습니다."),
    NOT_FOUND_ANNOUNCEMENT(HttpStatus.NOT_FOUND,"채용공고가 존재하지 않습니다.");
    private final HttpStatus status;
    private final String message;
}
