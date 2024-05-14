package com.example.librarymanagementsystem.model.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatronReqDTO {
    private String patronName;
    private String patronPhone;
    private String patronEmail;
}
