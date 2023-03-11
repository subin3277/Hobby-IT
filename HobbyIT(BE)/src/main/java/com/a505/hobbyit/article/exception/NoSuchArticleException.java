package com.a505.hobbyit.article.exception;

public class NoSuchArticleException extends RuntimeException {

    public NoSuchArticleException(String message) {
        super(message);
    }

    public NoSuchArticleException() {
        this("게시글이 존재하지 않습니다.");
    }
}
