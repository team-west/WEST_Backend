package com.example.west.domain.style.exception;

import com.example.west.global.error.exception.ErrorCode;
import com.example.west.global.error.exception.WestException;

public class StyleNotFoundException extends WestException {
    public static final WestException EXCEPTION = new StyleNotFoundException();

    private StyleNotFoundException() {
        super(ErrorCode.STYLE_NOT_FOUND);
    }
}
