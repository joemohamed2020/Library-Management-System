package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.Exception.Book.BookNotFoundException;
import com.example.librarymanagementsystem.model.DTO.BookReqDTO;
import com.example.librarymanagementsystem.model.DTO.BookResDTO;
import com.example.librarymanagementsystem.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    @GetMapping(path = "")
    public List<BookResDTO> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping(path = "/{id}")
    public BookResDTO getBookById(@PathVariable(name = "id") @Valid long bookId) throws BookNotFoundException {
        return bookService.getBookById(bookId);
    }
    @PostMapping(path = "")
    public BookResDTO addBook(@RequestBody @Valid BookReqDTO bookReqDTO){
        return bookService.addBook(bookReqDTO);
    }
    @PutMapping(path = "/{id}")
    public BookResDTO updateBookById(@PathVariable(name = "id")long bookId,@RequestBody BookReqDTO bookReqDTO) throws BookNotFoundException {
        return bookService.updateBookById(bookId,bookReqDTO);
    }
    @DeleteMapping(path = "/{id}")
    public void deleteBookById(@PathVariable(name = "id")long bookId){
        bookService.deleteBookById(bookId);
    }

}
