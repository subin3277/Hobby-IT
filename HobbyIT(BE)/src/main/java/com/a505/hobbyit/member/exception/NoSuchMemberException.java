package com.a505.hobbyit.member.exception;

public class NoSuchMemberException extends RuntimeException {
    public NoSuchMemberException(String message) {
        super(message);
    }

    public NoSuchMemberException() {
        this("사용자를 찾을 수 없습니다.");
    }
}
