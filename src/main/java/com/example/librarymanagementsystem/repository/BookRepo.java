package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<BookEntity,Long> {
    BookEntity findByBookId(long bookId);
}
