package com.example.librarymanagementsystem.model.mapper;

import com.example.librarymanagementsystem.model.DTO.BorrowReqDTO;
import com.example.librarymanagementsystem.model.DTO.BorrowResDTO;
import com.example.librarymanagementsystem.model.entity.BorrowEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BorrowMapper {
    BorrowEntity toBorrowEntity(BorrowReqDTO borrowReqDTO);
    BorrowResDTO toResDTO(BorrowEntity borrowEntity);
}
