package com.example.librarymanagementsystem.model.mapper;

import com.example.librarymanagementsystem.model.DTO.BookReqDTO;
import com.example.librarymanagementsystem.model.DTO.BookResDTO;
import com.example.librarymanagementsystem.model.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookEntity toBookEntity(BookReqDTO bookReqDTO);
    BookResDTO toResDTO(BookEntity book);
    BookEntity toBookEntity(BookResDTO bookResDTO);
    List<BookResDTO> toResDTO(List<BookEntity>bookEntities);
}
