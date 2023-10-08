package com.example.demo.company.domain;

import com.example.demo.common.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Announcement extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    @Column(nullable = false)
    private String position;
    @Column(nullable = false)
    private String content;
    private long recruitmentCompensation;
    @Column(nullable = false)
    private String skill;

    public Announcement(Company company, String position, String content,
        long recruitmentCompensation,
        String skill) {
        this.company = company;
        this.position = position;
        this.content = content;
        this.recruitmentCompensation = recruitmentCompensation;
        this.skill = skill;
    }
    public Company findCompany() {
        return company != null ? company : null;
    }

    public void update(String position, String content, String skill, long recruitmentCompensation) {
        this.position = position;
        this.content = content;
        this.skill = skill;
        this.recruitmentCompensation = recruitmentCompensation;
    }
}
