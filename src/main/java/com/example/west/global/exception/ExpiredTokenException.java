package com.example.west.global.exception;


import com.example.west.global.error.exception.ErrorCode;
import com.example.west.global.error.exception.WestException;

public class ExpiredTokenException extends WestException {
    public static final WestException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
