package com.example.demo.company;

import com.example.demo.company.domain.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyWriteService {
    private final CompanyRepository companyRepository;

    public Long create(String name, String country, String area) {
        return companyRepository.save(new Company(name,country,area)).getId();
    }
}
