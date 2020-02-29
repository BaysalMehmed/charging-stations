package com.baysalmehmed.exception.handler;

import com.baysalmehmed.exception.type.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> generalException(Exception exception) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ExceptionModel(exception.getMessage(), httpStatus) , httpStatus);
    }
}
