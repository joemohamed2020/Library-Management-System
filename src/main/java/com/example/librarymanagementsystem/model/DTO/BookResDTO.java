package com.example.librarymanagementsystem.model.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResDTO {
    private String bookTitle;
    private String bookAuthor;
    private Long bookPublicationYear;
    private String bookISBN;
    private Long numberOfCopies;
}
