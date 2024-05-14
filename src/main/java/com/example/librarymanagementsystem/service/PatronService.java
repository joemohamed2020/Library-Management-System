package com.example.librarymanagementsystem.service;
import com.example.librarymanagementsystem.Exception.Patron.PatronNotFoundException;
import com.example.librarymanagementsystem.model.DTO.PatronReqDTO;
import com.example.librarymanagementsystem.model.DTO.PatronResDTO;
import com.example.librarymanagementsystem.model.entity.PatronEntity;
import com.example.librarymanagementsystem.model.mapper.PatronMapper;
import com.example.librarymanagementsystem.repository.PatronRepo;
import jakarta.transaction.Transactional;
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
    public PatronResDTO getPatronById(long patronId) throws PatronNotFoundException {
        PatronEntity patron = patronRepo.findByPatronId(patronId);
        if (patron!=null){
            return patronMapper.toResDTO(patron);
        }
        throw new PatronNotFoundException("Patron With Id: {"+patronId+"} Is Not Found");
    }
    @Transactional
    public PatronResDTO addPatron(PatronReqDTO patronReqDTO){
        return patronMapper.toResDTO(patronRepo.save(patronMapper.toPatronEntity(patronReqDTO)));
    }
    @Transactional
    public PatronResDTO updatePatronById(long patronId,PatronReqDTO patronReqDTO) throws PatronNotFoundException {
        PatronEntity patron;
        if(patronRepo.existsById(patronId)){
            patron = patronRepo.findByPatronId(patronId);
            if (patronReqDTO.getPatronEmail()!=null){
                patron.setPatronEmail(patronReqDTO.getPatronEmail());
            }  if (patronReqDTO.getPatronPhone()!=null) {
                patron.setPatronPhone(patronReqDTO.getPatronPhone());
            } if (patronReqDTO.getPatronName()!=null) {
                patron.setPatronName(patronReqDTO.getPatronName());
            }
            return patronMapper.toResDTO(patronRepo.save(patron));
        }else{
            return getPatronById(patronId);
        }
    }
    @Transactional
    public void deletePatronById(long patronId){
        if (patronRepo.existsById(patronId)) {
            patronRepo.deleteById(patronId);
        }
    }
}
