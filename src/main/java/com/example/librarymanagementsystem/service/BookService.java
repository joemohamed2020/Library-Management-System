package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.DTO.BookReqDTO;
import com.example.librarymanagementsystem.model.DTO.BookResDTO;
import com.example.librarymanagementsystem.model.entity.BookEntity;
import com.example.librarymanagementsystem.model.mapper.BookMapper;
import com.example.librarymanagementsystem.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;

    private final BookMapper bookMapper;
    public BookResDTO addBook(BookReqDTO bookReqDTO){
        return bookMapper.toResDTO(bookRepo.save(bookMapper.toBookEntity(bookReqDTO)));
    }
    public List<BookResDTO> getAllBooks(){
        return bookMapper.toResDTO(bookRepo.findAll());
    }
    public BookResDTO getBookById(long bookId){
        return bookMapper.toResDTO(bookRepo.findByBookId(bookId));
    }
    public BookResDTO updateBookById(long bookId,BookReqDTO bookReqDTO){
        BookEntity book;
        if(bookRepo.existsById(bookId)){
            book = bookRepo.findByBookId(bookId);
            if (bookReqDTO.getBookTitle()!=null){
                book.setBookTitle(bookReqDTO.getBookTitle());
            } else if (bookReqDTO.getBookAuthor()!=null) {
                book.setBookAuthor(bookReqDTO.getBookAuthor());
            }else if (bookReqDTO.getBookPublicationYear()!=null) {
                book.setBookAuthor(bookReqDTO.getBookPublicationYear());
            }else if (bookReqDTO.getBookISBN()!=null) {
                book.setBookAuthor(bookReqDTO.getBookISBN());
            }
            return bookMapper.toResDTO(bookRepo.save(book));
        }else{
            return getBookById(bookId);
        }
    }

    public void deleteBookById(long bookId){
        if (bookRepo.existsById(bookId)) {
            bookRepo.deleteById(bookId);
        }
    }
}
