package com.baysalmehmed.exception.handler;

import com.baysalmehmed.exception.type.charger.ChargerDidNotSaveException;
import com.baysalmehmed.exception.type.charger.ChargerDoesNotExistException;
import com.baysalmehmed.exception.type.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ChargerExceptionController {
    @ExceptionHandler(value = ChargerDoesNotExistException.class)
    public ResponseEntity<Object> chargerDoesNotExistException(ChargerDoesNotExistException exception) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ExceptionModel(exception.getMessage(), httpStatus) , httpStatus);
    }

    @ExceptionHandler(value = ChargerDidNotSaveException.class)
    public ResponseEntity<Object> chargerDidNotSaveException(ChargerDidNotSaveException exception) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ExceptionModel(exception.getMessage(), httpStatus) , httpStatus);
    }
}
