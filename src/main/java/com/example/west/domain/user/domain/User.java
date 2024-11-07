package com.example.west.domain.user.domain;

import com.example.west.domain.user.domain.type.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "user_name", columnDefinition = "varchar(10)", nullable = false)
    private String name;

    @Column(name = "user_number", columnDefinition = "varchar(20)", nullable = false)
    private String number;

    @Column(name = "account_id", columnDefinition = "varchar(30)", nullable = false)
    private String accountId;

    @Column(name = "password", columnDefinition = "varchar(100)", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender", nullable = false)
    private Gender gender;

    @Builder
    public User(String name, String number, String accountId, String password, Gender gender) {
        this.name = name;
        this.number = number;
        this.accountId = accountId;
        this.password = password;
        this.gender = gender;
    }
}
