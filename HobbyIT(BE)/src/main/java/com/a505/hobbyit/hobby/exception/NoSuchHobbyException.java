package com.a505.hobbyit.hobby.exception;

public class NoSuchHobbyException extends RuntimeException{
    public NoSuchHobbyException(final String message) {
        super(message);
    }

    public NoSuchHobbyException() {
        this("존재하지 않는 모임입니다.");
    }
}
