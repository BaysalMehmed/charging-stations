package com.baysalmehmed.exception.handler;

import com.baysalmehmed.exception.type.chargerType.ChargerTypeDidNotSaveException;
import com.baysalmehmed.exception.type.chargerType.ChargerTypeDoesNotExistException;
import com.baysalmehmed.exception.type.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ChargerTypeExceptionController {

    @ExceptionHandler(value = ChargerTypeDoesNotExistException.class)
    public ResponseEntity<Object> chargerDoesNotExistException(ChargerTypeDoesNotExistException exception) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ExceptionModel(exception.getMessage(), httpStatus) , httpStatus);
    }

    @ExceptionHandler(value = ChargerTypeDidNotSaveException.class)
    public ResponseEntity<Object> chargerTypeDidNotSaveException(ChargerTypeDidNotSaveException exception) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ExceptionModel(exception.getMessage(), httpStatus) , httpStatus);
    }
}
