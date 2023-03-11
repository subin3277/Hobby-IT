package com.a505.hobbyit.article.exception;

public class UnAuthorizedArticleException extends RuntimeException {

    public UnAuthorizedArticleException(String message) {
        super(message);
    }

    public UnAuthorizedArticleException() {
        this("게시글에 대한 권한이 없습니다.");
    }
}
