package com.example.west.domain.user.presentation.dto;

import com.example.west.domain.user.domain.type.Sex;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupRequest {

    @NotNull(message = "이름을 입력하세요")
    @Size(min = 2, max = 10)
    private String name;

    @NotNull(message = "전화번호를 입력하세요")
    @Size(min = 5, max = 20)
    private String number;

    @NotNull(message = "아이디를 입력하세요")
    @Size(min = 8, max = 10)
    private String accountId;

    @NotNull(message = "비밀번호를 입력하세요")
    @Size(min = 10, max = 100)
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;<=>?@＼^_`{|}~]{8,20}$")
    private String password;

    @NotNull(message = "성별을 선택하세요.")
    private Sex sex;
}
