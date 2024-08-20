package com.example.west.domain.user.exception;

import com.example.west.global.error.exception.ErrorCode;
import com.example.west.global.error.exception.WestException;

public class AccountIdAlreadyExistsException extends WestException {
    public static final WestException EXCEPTION = new AccountIdAlreadyExistsException();

    private AccountIdAlreadyExistsException() {
        super(ErrorCode.ACCOUNT_ID_ALREADY_EXISTS);
    }
}
