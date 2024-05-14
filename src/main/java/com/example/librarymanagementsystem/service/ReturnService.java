package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.DTO.ReturnResDTO;
import com.example.librarymanagementsystem.model.entity.BorrowEntity;
import com.example.librarymanagementsystem.model.mapper.ReturnMapper;
import com.example.librarymanagementsystem.repository.BorrowRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ReturnService {
    private final BorrowRepo borrowRepo;
    private final ReturnMapper returnMapper;
    public ReturnResDTO returnBook(Long patronId, Long bookId){
        if (borrowRepo.existsBorrowEntityByBookIdAndPatronIdAndReturnDateIsNull(bookId,patronId)){
            BorrowEntity borrowEntity =borrowRepo.findByBookIdAndPatronIdAndReturnDateIsNull(bookId,patronId);
            borrowEntity.setReturnDate(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
            return (returnMapper.toResDTO(borrowRepo.save(borrowEntity)));
        }
        return returnMapper.toResDTO(borrowRepo.findByBookIdAndPatronIdAndReturnDateIsNull(bookId,patronId));
    }
}
