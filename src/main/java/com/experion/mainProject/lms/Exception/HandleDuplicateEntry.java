package com.experion.mainProject.lms.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class HandleDuplicateEntry {
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> duplicateEntryException(SQLIntegrityConstraintViolationException exception, WebRequest request){
        return new ResponseEntity<>("Duplicate entry", HttpStatus.CREATED);
    }
}
