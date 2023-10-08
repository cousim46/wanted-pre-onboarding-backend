package com.example.demo.company;

import com.example.demo.company.dto.CompanyDto.Create;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyWriteService companyWriteService;
    @PostMapping("/create")
    public Long create(@Valid @RequestBody Create create) {
        return companyWriteService.create(create.getName(),create.getCountry(),create.getArea());
    }
}
