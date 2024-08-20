package com.example.west.domain.user.exception;

import com.example.west.global.error.exception.ErrorCode;
import com.example.west.global.error.exception.WestException;

public class PasswordMismatchException extends WestException {
    public static final WestException EXCEPTION = new PasswordMismatchException();

    private PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
