package com.a505.hobbyit.hobbyarticlecomment.exception;

public class NoSuchCommentException extends RuntimeException{
    public NoSuchCommentException() {
        this("존재하지 않는 댓글입니다");
    }

    public NoSuchCommentException(String message) {
        super(message);
    }
}
