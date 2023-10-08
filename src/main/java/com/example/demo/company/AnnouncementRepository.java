package com.example.demo.company;

import com.example.demo.company.domain.Announcement;
import com.example.demo.company.domain.Company;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    @Query("SELECT a.id From Announcement a WHERE a.company = :company")
    List<Long> findAllByCompany(@Param("company") Company company);
}
