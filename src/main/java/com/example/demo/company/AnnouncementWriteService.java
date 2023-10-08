package com.example.demo.company;

import com.example.demo.common.error.ErrorCode;
import com.example.demo.common.error.GlobalRuntimeException;
import com.example.demo.company.domain.Announcement;
import com.example.demo.company.domain.Company;
import com.example.demo.company.dto.AnnouncementDto.CreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class AnnouncementWriteService {
    private final AnnouncementRepository announcementRepository;
    private final CompanyRepository companyRepository;

    public Long create(CreateRequest request)  {
        Company company = companyRepository.findById(request.getCompanyId())
            .orElseThrow(() -> new GlobalRuntimeException(
                ErrorCode.NOT_FOUND_COMPANY));
        Announcement announcement = new Announcement(company, request.getPosition(),
            request.getContent(), request.getRecruitmentCompensation(), request.getSkill());
        return announcementRepository.save(announcement).getId();
    }

    public void delete(Long id) {
        announcementRepository.deleteById(id);
    }
}
