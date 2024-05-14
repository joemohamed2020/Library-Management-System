package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.Exception.Book.BookHasNoCopiesException;
import com.example.librarymanagementsystem.Exception.Book.BookNotFoundException;
import com.example.librarymanagementsystem.Exception.Patron.PatronNotFoundException;
import com.example.librarymanagementsystem.model.DTO.BorrowReqDTO;
import com.example.librarymanagementsystem.model.DTO.BorrowResDTO;
import com.example.librarymanagementsystem.service.BorrowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/borrow")
@RequiredArgsConstructor
public class BorrowController {
    private final BorrowService borrowService;
    @PostMapping(path = "/{bookId}/patron/{patronId}")
    public BorrowResDTO borrowBook(@Valid @PathVariable(name = "patronId") long patronId,@Valid @PathVariable(name = "bookId") long bookId,@Valid @RequestBody BorrowReqDTO borrowReqDTO) throws PatronNotFoundException, BookNotFoundException, BookHasNoCopiesException {
        return borrowService.BorrowBook(patronId,bookId,borrowReqDTO);
    }
}
