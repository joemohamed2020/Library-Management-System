package com.example.librarymanagementsystem.controller;
import com.example.librarymanagementsystem.Exception.Patron.PatronNotFoundException;
import com.example.librarymanagementsystem.model.DTO.PatronReqDTO;
import com.example.librarymanagementsystem.model.DTO.PatronResDTO;
import com.example.librarymanagementsystem.service.PatronService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/patrons")
@RequiredArgsConstructor
public class PatronController {
    private final PatronService patronService;
    @GetMapping(path = "")
    public List<PatronResDTO> getAllPatrons(){
        return patronService.getAllPatrons();
    }
    @GetMapping(path = "/{id}")
    public PatronResDTO getPatronById(@PathVariable(name = "id") @Valid long patronId) throws PatronNotFoundException {
        return patronService.getPatronById(patronId);
    }
    @PostMapping(path = "")
    public PatronResDTO addPatron(@RequestBody @Valid PatronReqDTO patronReqDTO){
        return patronService.addPatron(patronReqDTO);
    }
    @PutMapping(path = "/{id}")
    public PatronResDTO updatePatronById(@PathVariable(name = "id")long patronId,@RequestBody PatronReqDTO patronReqDTO) throws PatronNotFoundException {
        return patronService.updatePatronById(patronId,patronReqDTO);
    }
    @DeleteMapping(path = "/{id}")
    public void deletePatronById(@PathVariable(name = "id")long patronId){
        patronService.deletePatronById(patronId);
    }


}
