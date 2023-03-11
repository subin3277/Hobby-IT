package com.a505.hobbyit.hobbyarticle.exception;

public class UnAuthorizedException extends RuntimeException{
    public UnAuthorizedException() {
        this("접근 권한이 없습니다.");
    }

    public UnAuthorizedException(String message) {
        super(message);
    }
}
