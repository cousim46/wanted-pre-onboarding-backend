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
    @Column(nullable = false)
    private Company company;
    @Column(nullable = false)
    private String position;
    @Column(nullable = false)
    private String content;
    private Long recruitmentCompensation;
}
