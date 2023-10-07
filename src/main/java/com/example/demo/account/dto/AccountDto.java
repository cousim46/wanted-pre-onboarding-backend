package com.example.demo.account.dto;

import com.sun.istack.NotNull;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * packageName    : com.example.demo.account.dto
 * fileName       : AccountDto
 * author         : jhw1015
 * date           : 2023/10/08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/10/08           jhw1015           최초 생성
 */
public class AccountDto {

    @Getter
    @AllArgsConstructor
    public static class JoinRequest {
        @NotBlank
        private String name;
        private int age;
    }

}
