package com.example.librarymanagementsystem.model.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResDTO {
    @NotBlank(message = "Book Title Can't Be Blank")
    private String bookTitle;
    @NotBlank(message = "Book Author Can't Be Blank")
    private String bookAuthor;
    @Min(1)
    @Max(2024)
    @NotBlank(message = "Book Publication Year Can't Be Blank Add Value(1:2024)")
    private String bookPublicationYear;
    private String bookISBN;
    private int numberOfCopies;
}
