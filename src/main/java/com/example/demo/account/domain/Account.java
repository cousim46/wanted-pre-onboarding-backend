package com.example.demo.account.domain;

import com.example.demo.common.BaseEntity;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseEntity {
    private String name;
    private int age;

    public Account(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
