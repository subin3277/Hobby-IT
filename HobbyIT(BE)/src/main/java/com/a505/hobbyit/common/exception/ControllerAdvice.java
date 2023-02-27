package com.a505.hobbyit.common.exception;

import com.a505.hobbyit.article.exception.NoSuchArticleException;
import com.a505.hobbyit.article.exception.UnAuthorizedArticleException;
import com.a505.hobbyit.common.exception.dto.ErrorResponse;
import com.a505.hobbyit.common.file.exception.FileStorageException;
import com.a505.hobbyit.hobby.exception.DuplicatedHobbyException;
import com.a505.hobbyit.hobby.exception.InvalidHobbyException;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobby.exception.OverCapacityException;
import com.a505.hobbyit.hobbyarticlecomment.exception.NoSuchCommentException;
import com.a505.hobbyit.hobbymember.exception.NoSuchHobbyMemberException;
import com.a505.hobbyit.hobbymember.exception.UnAuthorizedHobbyMemberException;
import com.a505.hobbyit.hobbypostit.exception.NoSuchHobbyPostitException;
import com.a505.hobbyit.hobbypostit.exception.UnAuthorizedHobbyPostitException;
import com.a505.hobbyit.member.exception.DuplicatedMemberException;
import com.a505.hobbyit.member.exception.InvalidedAccessTokenException;
import com.a505.hobbyit.member.exception.InvalidedRefreshTokenException;
import com.a505.hobbyit.member.exception.NoSuchMemberException;
import com.a505.hobbyit.pending.exception.DuplicatedPendingException;
import com.a505.hobbyit.pending.exception.NoSuchPendingException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.NoSuchFileException;

@RestControllerAdvice
public class ControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler({
            InvalidedAccessTokenException.class,
            InvalidedRefreshTokenException.class,
            InvalidHobbyException.class})
    public ResponseEntity<ErrorResponse> handleInvalidException(final RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler({
            NoSuchMemberException.class,
            NoSuchHobbyException.class,
            NoSuchHobbyMemberException.class,
            NoSuchPendingException.class,
            NoSuchArticleException.class,
            NoSuchHobbyPostitException.class,
            NoSuchCommentException.class})
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(final RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler({
            DuplicatedMemberException.class,
            DuplicatedHobbyException.class,
            DuplicatedPendingException.class})
    public ResponseEntity<ErrorResponse> handleDuplicatedException(final RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler({
            UnAuthorizedHobbyMemberException.class,
            UnAuthorizedArticleException.class,
            UnAuthorizedHobbyPostitException.class})
    public ResponseEntity<ErrorResponse> handleUnAuthorizedException(final RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    @ExceptionHandler({NoSuchFileException.class, FileStorageException.class})
    public ResponseEntity<ErrorResponse> NoSuchFileException(final RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler({
            JwtException.class,
            ExpiredJwtException.class,
            UnsupportedJwtException.class,
            MalformedJwtException.class,
    })
    public ResponseEntity<ErrorResponse> JwtException(final RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    /*
    소모임 가입 시, 정원초과 시 발생하는 문제
     */
    @ExceptionHandler({
            OverCapacityException.class
    })
    public ResponseEntity<ErrorResponse> overCapacityException(final RuntimeException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
