package com.a505.hobbyit.hobby.exception;

public class OverCapacityException extends RuntimeException{
    public OverCapacityException() {
        this("정원이 가득 차 더이상 가입할 수 없습니다.");
    }

    public OverCapacityException(String message) {
        super(message);
    }
}
