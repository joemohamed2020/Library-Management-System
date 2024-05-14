package com.example.librarymanagementsystem.ExceptionHandler.Patron;

import com.example.librarymanagementsystem.Exception.Book.BookNotFoundException;
import com.example.librarymanagementsystem.Exception.Patron.PatronNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class PatronNotFoundExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(PatronNotFoundException.class)
    public Map<String,String> handlePatronNotFoundException(PatronNotFoundException exception){
        Map<String,String> exceptionList = new HashMap<>();
        exceptionList.put("errorMessage",exception.getMessage());
        return exceptionList;
    }
}
