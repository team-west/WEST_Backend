package com.example.west.domain.user.presentation;

import com.example.west.domain.auth.presentation.dto.response.TokenResponse;
import com.example.west.domain.user.presentation.dto.request.LoginRequest;
import com.example.west.domain.user.presentation.dto.request.SignupRequest;
import com.example.west.domain.user.service.LoginService;
import com.example.west.domain.user.service.ReissueService;
import com.example.west.domain.user.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final SignupService signupService;
    private final LoginService loginService;
    private final ReissueService reissueService;

    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignupRequest signupRequest) {
        signupService.signUp(signupRequest);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }

    @PutMapping("/reissue")
    public TokenResponse reissue(@RequestHeader(name = "refresh-token") @NotNull String refreshToken) {
        return reissueService.reissue(refreshToken);
    }
}
