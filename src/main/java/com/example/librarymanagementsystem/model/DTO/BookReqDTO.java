package com.example.librarymanagementsystem.model.DTO;


import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookReqDTO {
    private String bookTitle;
    private String bookAuthor;
    private String bookPublicationYear;
    private String bookISBN;
    private int numberOfCopies;
}
