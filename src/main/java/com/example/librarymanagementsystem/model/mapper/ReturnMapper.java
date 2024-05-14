package com.example.librarymanagementsystem.model.mapper;

import com.example.librarymanagementsystem.model.DTO.ReturnResDTO;
import com.example.librarymanagementsystem.model.entity.BorrowEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReturnMapper {
    ReturnResDTO toResDTO(BorrowEntity borrowEntity);
}
