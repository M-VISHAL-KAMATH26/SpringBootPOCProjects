package com.demo.library.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @NotBlank(message = "title cant be blank")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "author cant be blank")
    @Column(unique = true)
    private String author;

    @Positive(message="price must be greater than zero")
    @Column(nullable = false)
    private Double price;

    @Column(nullable = false,columnDefinition = "boolean default false")
    private boolean borrowed;
}
