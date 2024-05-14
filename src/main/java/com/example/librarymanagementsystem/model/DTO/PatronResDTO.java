package com.example.librarymanagementsystem.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatronResDTO {
    private String patronName;
    private String patronPhone;
    private String patronEmail;
}
