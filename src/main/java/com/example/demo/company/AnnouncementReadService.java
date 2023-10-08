package com.example.demo.company;


import com.example.demo.common.error.ErrorCode;
import com.example.demo.common.error.GlobalRuntimeException;
import com.example.demo.company.domain.Announcement;
import com.example.demo.company.domain.Company;
import com.example.demo.company.dto.AnnouncementDto.DetailResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AnnouncementReadService {
    private final AnnouncementRepository announcementRepository;

    public DetailResponse detail(Long id) {
        Announcement announcement = announcementRepository.findById(id)
            .orElseThrow(() -> new GlobalRuntimeException(ErrorCode.NOT_FOUND_ANNOUNCEMENT));
        Company company = announcement.findCompany();
        if(company == null) {
            throw  new GlobalRuntimeException(ErrorCode.NOT_FOUND_COMPANY);
        }
        List<Long> announcementIds = announcementRepository.findAllByCompany(company);
        return new DetailResponse(announcement,company,announcementIds);
    }
}
