package com.a505.hobbyit.pending.exception;

public class DuplicatedPendingException extends RuntimeException{
    public DuplicatedPendingException() {
        this("이미 신청된 Hobby입니다.");
    }

    public DuplicatedPendingException(String message) {
        super(message);
    }
}
