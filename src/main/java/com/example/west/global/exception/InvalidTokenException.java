package com.example.west.global.exception;


import com.example.west.global.error.exception.ErrorCode;
import com.example.west.global.error.exception.WestException;

public class InvalidTokenException extends WestException {
    public static final WestException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
