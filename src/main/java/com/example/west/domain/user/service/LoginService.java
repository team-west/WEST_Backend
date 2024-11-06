package com.example.west.domain.user.service;

import com.example.west.domain.auth.presentation.dto.response.TokenResponse;
import com.example.west.domain.user.domain.User;
import com.example.west.domain.user.domain.repository.UserRepository;
import com.example.west.domain.user.exception.PasswordMismatchException;
import com.example.west.domain.user.exception.UserNotFoundException;
import com.example.west.domain.user.presentation.dto.request.LoginRequest;
import com.example.west.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenResponse login(LoginRequest request) {

        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return jwtTokenProvider.createToken(user.getAccountId());
    }
}
