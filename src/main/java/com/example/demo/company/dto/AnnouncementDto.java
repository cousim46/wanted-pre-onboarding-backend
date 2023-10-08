package com.example.demo.company.dto;

import com.example.demo.company.domain.Announcement;
import com.example.demo.company.domain.Company;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;


public class AnnouncementDto {
    @AllArgsConstructor
    @Getter
    public static class CreateRequest {
        @NotNull
        private Long companyId;
        @NotBlank
        private String position;
        @NotBlank
        private String content;
        private long recruitmentCompensation;
        @NotBlank
        private String skill;
    }

    @Getter
    public static class DetailResponse {
        private final Long announcementId;
        private final String companyName;
        private final String country;
        private final String area;
        private final long recruitmentCompensation;
        private final String skill;
        private final String content;
        private List<Long> announcementIds;

        public DetailResponse(Announcement announcement, Company company, List<Long> announcementIds) {
            this.announcementId = announcement.getId();
            this.companyName = company.getName();
            this.country = company.getCountry();
            this.area = company.getArea();
            this.recruitmentCompensation = announcement.getRecruitmentCompensation();
            this.skill = announcement.getSkill();
            this.content = announcement.getContent();
            this.announcementIds = announcementIds;
        }
    }

    @AllArgsConstructor
    @Getter
    public static class UpdateRequest {
        @NotBlank
        private String position;
        private long recruitmentCompensation;
        @NotBlank
        private String content;
        @NotBlank
        private String skill;
    }

    @AllArgsConstructor
    @Getter
    public static class RegisterRequest {
        @NotNull
        private Long announcementId;
        @NotNull
        private Long accountId;
    }

    @AllArgsConstructor
    @Getter
    public static class ListResponse {
        private Long announcementId;
        private String companyName;
        private String country;
        private String area;
        private String position;
        private long recruitmentCompensation;
        private String skill;
    }

}
