package com.example.librarymanagementsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Patrons")
public class PatronEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patron_id")
    private Long patronId;
    @NotBlank(message = "Patron Name Can't Be Blank")
    @Column(name = "patron_name")
    private String patronName;
    @NotBlank(message = "Patron Phone Can't Be Blank")
    @Pattern(regexp = "\\d{11}",message = "Enter Valid Mobile Phone")
    @Column(name = "patron_phone",unique = true)
    private String patronPhone;
    @NotBlank(message = "Patron Email Can't Be Blank")
    @Email(message = "Enter Valid Email")
    @Column(name = "patron_email",unique = true)
    private String patronEmail;
}
