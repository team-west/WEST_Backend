package com.example.west.domain.style.exception;

import com.example.west.global.error.exception.ErrorCode;
import com.example.west.global.error.exception.WestException;

public class StyleFavoriteNotFound extends WestException {
    public static final WestException EXCEPTION = new StyleFavoriteNotFound();

    private StyleFavoriteNotFound() {
        super(ErrorCode.STYLE_FAVORITE_NOT_FOUND);
    }
}
