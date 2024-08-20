package com.example.west.domain.user.presentation.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequest {

    @NotNull(message = "아이디을 입력하세요")
    private String accountId;

    @NotNull(message = "비밀번호를 입력하세요")
    private String password;
}
