package com.a505.hobbyit.member.exception;

public class DuplicatedMemberException extends RuntimeException {
    public DuplicatedMemberException(String message) {
        super(message);
    }

    public DuplicatedMemberException() {
        this("중복된 이메일입니다.");
    }
}
