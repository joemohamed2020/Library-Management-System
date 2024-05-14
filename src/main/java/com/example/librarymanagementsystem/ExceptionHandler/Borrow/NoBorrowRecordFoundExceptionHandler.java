package com.example.librarymanagementsystem.ExceptionHandler.Borrow;

import com.example.librarymanagementsystem.Exception.Book.BookNotFoundException;
import com.example.librarymanagementsystem.Exception.Borrow.NoBorrowRecordFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class NoBorrowRecordFoundExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NoBorrowRecordFoundException.class)
    public Map<String,String> handleNoBorrowRecordFoundException(NoBorrowRecordFoundException exception){
        Map<String,String> exceptionList = new HashMap<>();
        exceptionList.put("errorMessage",exception.getMessage());
        return exceptionList;
    }
}
