package com.example.demo.company;

import com.example.demo.account.AccountRepository;
import com.example.demo.account.domain.Account;
import com.example.demo.common.error.ErrorCode;
import com.example.demo.common.error.GlobalRuntimeException;
import com.example.demo.company.domain.Announcement;
import com.example.demo.company.domain.AnnouncementHistory;
import com.example.demo.company.domain.Company;
import com.example.demo.company.dto.AnnouncementDto.CreateRequest;
import com.example.demo.company.dto.AnnouncementDto.RegisterRequest;
import com.example.demo.company.dto.AnnouncementDto.UpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class AnnouncementWriteService {

    private final AnnouncementRepository announcementRepository;
    private final CompanyRepository companyRepository;
    private final AccountRepository accountRepository;
    private final AnnouncementHistoryRepository announcementHistoryRepository;

    public Long create(CreateRequest request) {
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

    public void update(Long id, UpdateRequest updateRequest) {
        Announcement announcement = announcementRepository.findById(id)
            .orElseThrow(() -> new GlobalRuntimeException(ErrorCode.NOT_FOUND_ANNOUNCEMENT));

        announcement.update(updateRequest.getPosition(), updateRequest.getContent(),
            updateRequest.getSkill(), updateRequest.getRecruitmentCompensation());
    }

    public Long register(RegisterRequest request) {
        Account account = accountRepository.findById(request.getAccountId())
            .orElseThrow(() -> new GlobalRuntimeException(ErrorCode.NOT_FOUND_ACCOUNT));
        Announcement announcement = announcementRepository.findById(request.getAnnouncementId())
            .orElseThrow(() -> new GlobalRuntimeException(ErrorCode.NOT_FOUND_ANNOUNCEMENT));
        if(announcementHistoryRepository.existsByAccountAndAnnouncement(account, announcement)) {
            throw new GlobalRuntimeException(ErrorCode.ALREADY_REGISTER);
        }
        return announcementHistoryRepository.save(new AnnouncementHistory(account,announcement)).getId();
    }
}
