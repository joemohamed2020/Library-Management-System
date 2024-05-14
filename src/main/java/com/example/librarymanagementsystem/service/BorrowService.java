package com.example.librarymanagementsystem.service;


import com.example.librarymanagementsystem.Exception.Book.BookHasNoCopiesException;
import com.example.librarymanagementsystem.Exception.Book.BookNotFoundException;
import com.example.librarymanagementsystem.Exception.Patron.PatronNotFoundException;
import com.example.librarymanagementsystem.model.DTO.BorrowReqDTO;
import com.example.librarymanagementsystem.model.DTO.BorrowResDTO;
import com.example.librarymanagementsystem.model.entity.BookEntity;
import com.example.librarymanagementsystem.model.entity.BorrowEntity;
import com.example.librarymanagementsystem.model.entity.PatronEntity;
import com.example.librarymanagementsystem.model.mapper.BookMapper;
import com.example.librarymanagementsystem.model.mapper.BorrowMapper;
import com.example.librarymanagementsystem.model.mapper.PatronMapper;
import com.example.librarymanagementsystem.repository.BookRepo;
import com.example.librarymanagementsystem.repository.BorrowRepo;
import com.example.librarymanagementsystem.repository.PatronRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BorrowService {

    private final BorrowMapper borrowMapper;
    private final BorrowRepo borrowRepo;
    private final BookService bookService;
    private final BookMapper bookMapper;
    private final BookRepo bookRepo;
    private final PatronService patronService;
    private final PatronMapper patronMapper;
    @Transactional
    public BorrowResDTO BorrowBook(Long patronId,Long bookId,BorrowReqDTO borrowReqDTO) throws BookNotFoundException, PatronNotFoundException, BookHasNoCopiesException {
        BorrowEntity borrowEntity;
        patronMapper.toPatronEntity(patronService.getPatronById(patronId));
        BookEntity bookEntity = bookMapper.toBookEntity(bookService.getBookById(bookId));
        if (bookEntity.getNumberOfCopies()<borrowReqDTO.getNumberOfCopies()){
            throw new BookHasNoCopiesException("Number Of Copies Available Is: "+bookEntity.getNumberOfCopies());
        }
        if (borrowRepo.existsBorrowEntityByBookIdAndPatronIdAndReturnDateIsNull(bookId,patronId)){
                borrowEntity = borrowRepo.findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId);
                borrowEntity.setNumberOfCopies(borrowEntity.getNumberOfCopies() + borrowReqDTO.getNumberOfCopies());
                borrowRepo.save(borrowEntity);
                bookEntity.setBookId(bookId);
                bookEntity.setNumberOfCopies(bookEntity.getNumberOfCopies()-borrowReqDTO.getNumberOfCopies());
                bookRepo.save(bookEntity);
                return borrowMapper.toResDTO(borrowRepo.save(borrowEntity));
        }
         borrowEntity= borrowMapper.toBorrowEntity(borrowReqDTO);
         borrowEntity.setBookId(bookId);
         borrowEntity.setPatronId(patronId);
         bookEntity.setBookId(bookId);
         bookEntity.setNumberOfCopies(bookEntity.getNumberOfCopies()-borrowReqDTO.getNumberOfCopies());
         bookRepo.save(bookEntity);
        return borrowMapper.toResDTO(borrowRepo.save(borrowEntity));
    }
}
