package com.a505.hobbyit.pending.exception;

public class NoSuchPendingException extends RuntimeException{
    public NoSuchPendingException() {
        this("유효한 소모임 대기가 아닙니다.");
    }

    public NoSuchPendingException(String message) {
        super(message);
    }
}
