package com.example.librarymanagementsystem.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BorrowingRecord")
public class BorrowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private Long borrowId;
    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "patron_id")
    private Long patronId;
    @NotNull(message = "How Many Copies?!")
    @Min(value = 1,message = "How Many Copies?!")
    @Column(name = "number_of_copies")
    private Long numberOfCopies;
    @NotBlank(message = "Borrow Date should be Not Blank")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(name = "borrowing_date")
    private String borrowingDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(name = "return_date")
    private String returnDate;
}
