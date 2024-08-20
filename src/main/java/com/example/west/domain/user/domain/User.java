package com.example.west.domain.user.domain;

import com.example.west.domain.user.domain.type.Sex;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String number;

    @Column(name = "account_id", columnDefinition = "varchar(30)", nullable = false)
    private String accountId;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender", nullable = false)
    private Sex sex;

    @Builder
    public User(String name, String number, String accountId, String password, Sex sex) {
        this.name = name;
        this.number = number;
        this.accountId = accountId;
        this.password = password;
        this.sex = sex;
    }
}
