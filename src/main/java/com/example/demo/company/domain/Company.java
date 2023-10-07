package com.example.demo.company.domain;

import com.example.demo.common.BaseEntity;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company extends BaseEntity {

    private String name;
    private String country;
    private String area;
}
