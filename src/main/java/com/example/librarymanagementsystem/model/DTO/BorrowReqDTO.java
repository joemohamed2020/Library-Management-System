package com.example.librarymanagementsystem.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowReqDTO {
    @NotNull(message = "How Many Copies?!")
    @Min(value = 1,message = "How Many Copies?!")
    private Long numberOfCopies;
    @NotBlank(message = "Borrow Date should be Not Blank")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private String borrowingDate;
}
