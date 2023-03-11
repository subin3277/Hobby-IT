package com.a505.hobbyit.member.exception;

public class InvalidedRefreshTokenException extends RuntimeException {
    public InvalidedRefreshTokenException(String message) {
        super(message);
    }

    public InvalidedRefreshTokenException() {
        this("Refresh Token 정보가 유효하지 않습니다.");
    }
}
