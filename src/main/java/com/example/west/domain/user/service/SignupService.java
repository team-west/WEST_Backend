package com.example.west.domain.user.service;

import com.example.west.domain.user.domain.User;
import com.example.west.domain.user.domain.repository.UserRepository;
import com.example.west.domain.user.exception.UserAlreadyExistException;
import com.example.west.domain.user.presentation.dto.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(SignupRequest signupRequest) {
        if (userRepository.existsByAccountId(signupRequest.getAccountId())) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        String password = passwordEncoder.encode(signupRequest.getPassword());

        userRepository.save(
                User.builder()
                        .accountId(signupRequest.getAccountId())
                        .name(signupRequest.getName())
                        .number(signupRequest.getNumber())
                        .password(password)
                        .gender(signupRequest.getGender())
                        .build()
        );
    }
}
