package com.example.demo.account.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;


public class AccountDto {

    @Getter
    @AllArgsConstructor
    public static class JoinRequest {
        @NotBlank
        private String name;
        private int age;
    }

}
