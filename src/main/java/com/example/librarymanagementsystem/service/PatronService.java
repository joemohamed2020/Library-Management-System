package com.example.librarymanagementsystem.service;
import com.example.librarymanagementsystem.model.DTO.PatronReqDTO;
import com.example.librarymanagementsystem.model.DTO.PatronResDTO;
import com.example.librarymanagementsystem.model.entity.PatronEntity;
import com.example.librarymanagementsystem.model.mapper.PatronMapper;
import com.example.librarymanagementsystem.repository.PatronRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatronService {
    private final PatronMapper patronMapper;
    private final PatronRepo patronRepo;
    public List<PatronResDTO> getAllPatrons(){
        return patronMapper.toResDTO(patronRepo.findAll());
    }
    public PatronResDTO getPatronById(long patronId){
        return patronMapper.toResDTO(patronRepo.findByPatronId(patronId));
    }
    public PatronResDTO addPatron(PatronReqDTO patronReqDTO){
        return patronMapper.toResDTO(patronRepo.save(patronMapper.toPatronEntity(patronReqDTO)));
    }
    public PatronResDTO updatePatronById(long patronId,PatronReqDTO patronReqDTO){
        PatronEntity patron;
        if(patronRepo.existsById(patronId)){
            patron = patronRepo.findByPatronId(patronId);
            if (patronReqDTO.getPatronEmail()!=null){
                patron.setPatronEmail(patronReqDTO.getPatronEmail());
            } else if (patronReqDTO.getPatronPhone()!=null) {
                patron.setPatronPhone(patronReqDTO.getPatronPhone());
            }else if (patronReqDTO.getPatronName()!=null) {
                patron.setPatronName(patronReqDTO.getPatronName());
            }
            return patronMapper.toResDTO(patronRepo.save(patron));
        }else{
            return getPatronById(patronId);
        }
    }
    public void deletePatronById(long patronId){
        if (patronRepo.existsById(patronId)) {
            patronRepo.deleteById(patronId);
        }
    }
}
