package com.a505.hobbyit.hobbymember.exception;

public class NoSuchHobbyMemberException extends RuntimeException{
    public NoSuchHobbyMemberException() {
        this("Hobby 회원을 찾을 수 없습니다.");
    }
    public NoSuchHobbyMemberException(String message) {
        super(message);
    }
}
