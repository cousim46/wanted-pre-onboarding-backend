package com.example.demo.company;

import static com.example.demo.company.domain.QAnnouncement.announcement;
import static com.example.demo.company.domain.QCompany.company;

import com.example.demo.company.dto.AnnouncementDto.ListResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AnnouncementQueryDslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<ListResponse> getAnnouncements(String search) {
        if (search == null) {
            return getAnnouncements();
        }
        return jpaQueryFactory.select(Projections.constructor(ListResponse.class,
                announcement.id, company.name, company.country, company.area,
                announcement.position, announcement.recruitmentCompensation, announcement.skill
            )).from(announcement)
            .where(company.name.contains(search)
                .or(announcement.position.contains(search))
                .or(announcement.skill.contains(search))
                .or(company.country.contains(search))
                .or(company.area.contains(search))
            )
            .innerJoin(announcement.company, company)
            .orderBy(announcement.createdAt.desc()).fetch();
    }

    public List<ListResponse> getAnnouncements() {
        return jpaQueryFactory.select(Projections.constructor(ListResponse.class,
                announcement.id, company.name, company.country, company.area,
                announcement.position, announcement.recruitmentCompensation, announcement.skill
            )).from(announcement)
            .innerJoin(announcement.company, company)
            .orderBy(announcement.createdAt.desc()).fetch();
    }

}
