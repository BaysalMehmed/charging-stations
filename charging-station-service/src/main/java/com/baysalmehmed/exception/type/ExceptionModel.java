package com.baysalmehmed.exception.type;

import org.springframework.http.HttpStatus;

public class ExceptionModel {
    public String exceptionMessage;
    public HttpStatus httpStatus;

    public ExceptionModel(String exceptionMessage, HttpStatus httpStatus) {
        this.exceptionMessage = exceptionMessage;
        this.httpStatus = httpStatus;
    }
}
