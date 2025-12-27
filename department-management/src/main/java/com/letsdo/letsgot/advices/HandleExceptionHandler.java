package com.letsdo.letsgot.advices;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class HandleExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)

    public ResponseEntity<String> handleResourceNotFound(NoSuchElementException exception){
        return new ResponseEntity<>("resource  not found", HttpStatus.NOT_FOUND);
    }
}
