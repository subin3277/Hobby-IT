package com.a505.hobbyit.hobby.exception;

public class DuplicatedHobbyException extends RuntimeException{
    public DuplicatedHobbyException() {
        this("중복된 이름입니다.");
    }

    public DuplicatedHobbyException(String message) {
        super(message);
    }
}
