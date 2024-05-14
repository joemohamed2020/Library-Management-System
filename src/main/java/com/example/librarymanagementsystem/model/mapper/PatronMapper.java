package com.example.librarymanagementsystem.model.mapper;
import com.example.librarymanagementsystem.model.DTO.PatronReqDTO;
import com.example.librarymanagementsystem.model.DTO.PatronResDTO;
import com.example.librarymanagementsystem.model.entity.PatronEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatronMapper {
    PatronEntity toPatronEntity(PatronReqDTO patronReqDTO);
    PatronResDTO toResDTO(PatronEntity patronEntity);
    PatronEntity toPatronEntity(PatronResDTO patronResDTO);
    List<PatronResDTO> toResDTO(List<PatronEntity>patronEntities);
}
