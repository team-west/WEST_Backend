package com.example.west.domain.user.exception;

import com.example.west.global.error.exception.ErrorCode;
import com.example.west.global.error.exception.WestException;

public class UserNotFoundException extends WestException {
    public static final WestException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
