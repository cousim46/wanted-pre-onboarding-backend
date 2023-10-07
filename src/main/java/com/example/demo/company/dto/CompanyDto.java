package com.example.demo.company.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * packageName    : com.example.demo.company.dto
 * fileName       : CompanyDto
 * author         : jhw1015
 * date           : 2023/10/08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/10/08           jhw1015           최초 생성
 */
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
