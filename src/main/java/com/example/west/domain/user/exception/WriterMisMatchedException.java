package com.example.west.domain.user.exception;

import com.example.west.global.error.exception.ErrorCode;
import com.example.west.global.error.exception.WestException;

public class WriterMisMatchedException extends WestException {
    public static final WestException EXCEPTION = new WriterMisMatchedException();

    private WriterMisMatchedException() {
        super(ErrorCode.WRITER_MISMATCH);
    }
}
