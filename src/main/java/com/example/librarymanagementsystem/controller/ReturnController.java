package com.example.librarymanagementsystem.controller;
import com.example.librarymanagementsystem.Exception.Book.BookNotFoundException;
import com.example.librarymanagementsystem.Exception.Borrow.NoBorrowRecordFoundException;
import com.example.librarymanagementsystem.Exception.Patron.PatronNotFoundException;
import com.example.librarymanagementsystem.model.DTO.ReturnResDTO;
import com.example.librarymanagementsystem.service.ReturnService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/return")
@RequiredArgsConstructor
public class ReturnController {
    private final ReturnService returnService;
    @PutMapping(path = "/{bookId}/patron/{patronId}")
    public ReturnResDTO returnBook(@Valid @PathVariable(name = "patronId") Long patronId, @Valid @PathVariable(name = "bookId") Long bookId) throws PatronNotFoundException, BookNotFoundException, NoBorrowRecordFoundException {
        return returnService.returnBook(patronId,bookId);
    }
}
