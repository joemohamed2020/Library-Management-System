package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.entity.PatronEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepo extends JpaRepository<PatronEntity,Long> {
    PatronEntity findByPatronId(long patronId);
}
