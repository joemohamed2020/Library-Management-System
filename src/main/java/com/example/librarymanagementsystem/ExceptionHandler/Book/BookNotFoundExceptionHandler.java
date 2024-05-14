package com.example.librarymanagementsystem.ExceptionHandler.Book;

import com.example.librarymanagementsystem.Exception.Book.BookNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BookNotFoundExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BookNotFoundException.class)
    public Map<String,String> handleBookNotFoundException(BookNotFoundException exception){
        Map<String,String> exceptionList = new HashMap<>();
        exceptionList.put("errorMessage",exception.getMessage());
        exceptionList.put("error","Internal Server Error");
        exceptionList.put("status","500");
        return exceptionList;
    }
}
