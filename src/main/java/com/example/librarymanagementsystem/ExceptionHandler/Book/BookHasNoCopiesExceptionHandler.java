package com.example.librarymanagementsystem.ExceptionHandler.Book;

import com.example.librarymanagementsystem.Exception.Book.BookHasNoCopiesException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class BookHasNoCopiesExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BookHasNoCopiesException.class)
    public Map<String,String> handleBookHasNoCopiesException(BookHasNoCopiesException exception){
        Map<String,String> exceptionList = new HashMap<>();
        exceptionList.put("errorMessage",exception.getMessage());
        return exceptionList;
    }
}
