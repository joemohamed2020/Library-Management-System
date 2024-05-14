package com.example.librarymanagementsystem.ExceptionHandler;



import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String,String> handleConstraintViolationException(ConstraintViolationException exception){
        Map<String,String> exceptionList = new HashMap<>();
        for(ConstraintViolation<?> constraintViolation:exception.getConstraintViolations()){
            exceptionList.put(constraintViolation.getPropertyPath().toString(),constraintViolation.getMessage());
        }
        return exceptionList;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Map<String,String> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception){
        Map<String,String> exceptionList = new HashMap<>();
        exceptionList.put("errorMessage",exception.getMessage());
        return exceptionList;
    }

}
