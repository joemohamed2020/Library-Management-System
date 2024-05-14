package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.entity.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepo extends JpaRepository<BorrowEntity,Long> {
    boolean existsBorrowEntityByBookIdAndPatronIdAndReturnDateIsNull(Long bookId,Long patronId);
    BorrowEntity findByBookIdAndPatronIdAndReturnDateIsNull(Long bookId,Long patronId);

}
