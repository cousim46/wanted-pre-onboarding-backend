package com.example.demo.company.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class CompanyDto {

    @AllArgsConstructor
    @Getter
    public static class Create {
        @NotBlank
        private String name;
        @NotBlank
        private String country;
        @NotBlank
        private String area;
    }

}
