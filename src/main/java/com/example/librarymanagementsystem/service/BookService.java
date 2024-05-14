package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.Exception.Book.BookNotFoundException;
import com.example.librarymanagementsystem.model.DTO.BookReqDTO;
import com.example.librarymanagementsystem.model.DTO.BookResDTO;
import com.example.librarymanagementsystem.model.entity.BookEntity;
import com.example.librarymanagementsystem.model.mapper.BookMapper;
import com.example.librarymanagementsystem.repository.BookRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;

    private final BookMapper bookMapper;
    @Transactional
    public BookResDTO addBook(BookReqDTO bookReqDTO){
        BookEntity bookEntity;
        if (bookRepo.existsByBookTitle(bookReqDTO.getBookTitle())){
            bookEntity = bookRepo.findByBookTitle(bookReqDTO.getBookTitle());
            bookEntity.setNumberOfCopies(bookEntity.getNumberOfCopies()+bookReqDTO.getNumberOfCopies());
            return bookMapper.toResDTO(bookRepo.save(bookEntity));
        }
        return bookMapper.toResDTO(bookRepo.save(bookMapper.toBookEntity(bookReqDTO)));
    }
    public List<BookResDTO> getAllBooks(){
        return bookMapper.toResDTO(bookRepo.findAll());
    }
    public BookResDTO getBookById(long bookId) throws BookNotFoundException {
        BookEntity book = bookRepo.findByBookId(bookId);
        if (book!=null){
            return bookMapper.toResDTO(book);
        }
        throw new BookNotFoundException("Book With Id: {"+bookId+"} Is Not Found");
    }
    @Transactional
    public BookResDTO updateBookById(long bookId,BookReqDTO bookReqDTO) throws BookNotFoundException {
        BookEntity book;
        if(bookRepo.existsById(bookId)){
            book = bookRepo.findByBookId(bookId);
            if (bookReqDTO.getBookTitle()!=null){
                book.setBookTitle(bookReqDTO.getBookTitle());
            }
            if (bookReqDTO.getBookAuthor()!=null) {
                book.setBookAuthor(bookReqDTO.getBookAuthor());
            }
            if (bookReqDTO.getBookPublicationYear()!=null) {
                book.setBookPublicationYear(bookReqDTO.getBookPublicationYear());
            }
            if (bookReqDTO.getBookISBN()!=null) {
                book.setBookISBN(bookReqDTO.getBookISBN());
            }
            if (bookReqDTO.getNumberOfCopies()!=null) {
                book.setNumberOfCopies(bookReqDTO.getNumberOfCopies());
            }
            return bookMapper.toResDTO(bookRepo.save(book));
        }else{
            return getBookById(bookId);
        }
    }
    @Transactional
    public void deleteBookById(long bookId){
        if (bookRepo.existsById(bookId)) {
            bookRepo.deleteById(bookId);
        }
    }
}
