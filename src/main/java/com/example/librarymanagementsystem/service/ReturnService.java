package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.Exception.Book.BookNotFoundException;
import com.example.librarymanagementsystem.Exception.Borrow.NoBorrowRecordFoundException;
import com.example.librarymanagementsystem.Exception.Patron.PatronNotFoundException;
import com.example.librarymanagementsystem.model.DTO.ReturnResDTO;
import com.example.librarymanagementsystem.model.entity.BookEntity;
import com.example.librarymanagementsystem.model.entity.BorrowEntity;
import com.example.librarymanagementsystem.model.mapper.BookMapper;
import com.example.librarymanagementsystem.model.mapper.PatronMapper;
import com.example.librarymanagementsystem.model.mapper.ReturnMapper;
import com.example.librarymanagementsystem.repository.BookRepo;
import com.example.librarymanagementsystem.repository.BorrowRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ReturnService {
    private final BorrowRepo borrowRepo;
    private final ReturnMapper returnMapper;
    private final PatronMapper patronMapper;
    private final PatronService patronService;
    private final BookMapper bookMapper;
    private final BookService bookService;
    private final BookRepo bookRepo;

    @Transactional
    public ReturnResDTO returnBook(Long patronId, Long bookId) throws PatronNotFoundException, BookNotFoundException, NoBorrowRecordFoundException {
        patronMapper.toPatronEntity(patronService.getPatronById(patronId));
        BookEntity bookEntity = bookMapper.toBookEntity(bookService.getBookById(bookId));
        if (borrowRepo.existsBorrowEntityByBookIdAndPatronIdAndReturnDateIsNull(bookId,patronId)){
            BorrowEntity borrowEntity =borrowRepo.findByBookIdAndPatronIdAndReturnDateIsNull(bookId,patronId);
            borrowEntity.setReturnDate(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
            bookEntity.setNumberOfCopies(bookEntity.getNumberOfCopies()+borrowEntity.getNumberOfCopies());
            bookEntity.setBookId(bookId);
            bookRepo.save(bookEntity);
            return (returnMapper.toResDTO(borrowRepo.save(borrowEntity)));
        }
        throw new NoBorrowRecordFoundException("Patron With Id: {"+patronId+"} Did Not Borrow This Book With Id: {"+bookId+"}");
    }
}
