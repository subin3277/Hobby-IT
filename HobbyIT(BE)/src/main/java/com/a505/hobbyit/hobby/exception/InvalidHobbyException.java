package com.a505.hobbyit.hobby.exception;

public class InvalidHobbyException extends RuntimeException{

    public InvalidHobbyException(final String message) {
        super(message);
    }

    public InvalidHobbyException() {
        this("잘못된 모암의 정보입니다.");
    }
}
