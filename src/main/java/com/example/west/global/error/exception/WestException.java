package com.example.west.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WestException extends RuntimeException{

    private final ErrorCode errorCode;
}
