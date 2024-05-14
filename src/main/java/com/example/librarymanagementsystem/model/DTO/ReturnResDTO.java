package com.example.librarymanagementsystem.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnResDTO {
    Long patronId;
    Long bookId;
    String borrowingDate;
    String returnDate;
}
