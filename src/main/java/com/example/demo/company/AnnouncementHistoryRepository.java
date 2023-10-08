package com.example.demo.company;

import com.example.demo.account.domain.Account;
import com.example.demo.company.domain.Announcement;
import com.example.demo.company.domain.AnnouncementHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementHistoryRepository extends JpaRepository<AnnouncementHistory, Long> {

    boolean existsByAccountAndAnnouncement(Account account, Announcement announcement);

}
