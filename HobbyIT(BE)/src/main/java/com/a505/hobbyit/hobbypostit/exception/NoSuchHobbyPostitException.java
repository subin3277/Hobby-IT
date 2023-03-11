package com.a505.hobbyit.hobbypostit.exception;

public class NoSuchHobbyPostitException extends RuntimeException {

    public NoSuchHobbyPostitException(String message) {
        super(message);
    }

    public NoSuchHobbyPostitException() {
        this("소모임에 가입된 회원이 아닙니다.");
    }
}
