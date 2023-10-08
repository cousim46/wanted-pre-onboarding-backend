package com.example.demo.company;

import com.example.demo.company.domain.Announcement;
import com.example.demo.company.domain.Company;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    List<Long> findAllByCompany(Company company);

}
