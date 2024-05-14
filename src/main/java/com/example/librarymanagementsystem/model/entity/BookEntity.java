package com.example.librarymanagementsystem.model.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;
    @NotBlank(message = "Book Title Can't Be Blank")
    @Column(name = "book_title",unique = true)
    private String bookTitle;
    @NotBlank(message = "Book Author Can't Be Blank")
    @Column(name = "book_author")
    private String bookAuthor;
    @Column(name = "book_publication_year")
    @Min(1)
    @Max(2024)
    private int bookPublicationYear;
    @Column(name = "book_ISBN")
    private String bookISBN;
    @Min(1)
    @Column(name = "number_of_copies")
    private int numberOfCopies;
}
