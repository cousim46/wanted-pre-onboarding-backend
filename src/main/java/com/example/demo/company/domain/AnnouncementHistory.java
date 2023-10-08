package com.example.demo.company.domain;

import com.example.demo.account.domain.Account;
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
public class AnnouncementHistory extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    private Announcement announcement;

    public AnnouncementHistory(Account account, Announcement announcement) {
        this.account = account;
        this.announcement = announcement;
    }
}
