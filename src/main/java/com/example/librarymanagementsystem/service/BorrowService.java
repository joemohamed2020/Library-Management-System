package com.example.librarymanagementsystem.service;


import com.example.librarymanagementsystem.model.DTO.BorrowReqDTO;
import com.example.librarymanagementsystem.model.DTO.BorrowResDTO;
import com.example.librarymanagementsystem.model.entity.BorrowEntity;
import com.example.librarymanagementsystem.model.mapper.BorrowMapper;
import com.example.librarymanagementsystem.repository.BorrowRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BorrowService {

    private final BorrowMapper borrowMapper;

    private final BorrowRepo borrowRepo;
    public BorrowResDTO BorrowBook(Long patronId,Long bookId,BorrowReqDTO borrowReqDTO){
        BorrowEntity borrowEntity;
        if (borrowRepo.existsBorrowEntityByBookIdAndPatronIdAndReturnDateIsNull(bookId,patronId)){
            borrowEntity = borrowRepo.findByBookIdAndPatronIdAndReturnDateIsNull(bookId,patronId);
            borrowEntity.setNumberOfCopies(borrowEntity.getNumberOfCopies()+ borrowReqDTO.getNumberOfCopies());
            borrowRepo.save(borrowEntity);
            return borrowMapper.toResDTO(borrowRepo.save(borrowEntity));
        }
         borrowEntity= borrowMapper.toBorrowEntity(borrowReqDTO);
         borrowEntity.setBookId(bookId);
         borrowEntity.setPatronId(patronId);
        return borrowMapper.toResDTO(borrowRepo.save(borrowEntity));
    }
}
