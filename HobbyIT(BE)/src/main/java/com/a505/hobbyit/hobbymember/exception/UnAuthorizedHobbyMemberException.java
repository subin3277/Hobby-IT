package com.a505.hobbyit.hobbymember.exception;

public class UnAuthorizedHobbyMemberException extends RuntimeException{
    public UnAuthorizedHobbyMemberException(final String message) {
        super(message);
    }

    public UnAuthorizedHobbyMemberException() {
        this("접근 권한이 없습니다.");
    }
}
