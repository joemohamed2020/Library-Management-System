package com.example.librarymanagementsystem.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowResDTO {
    private Long bookId;
    private Long patronId;
    private String borrowingDate;
    private Long numberOfCopies;
}
