package com.demo.library.model;


import jakarta.persistence.*;
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

    @Column(nullable = false)
    private String title;

    @Column(unique = true)
    private String author;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false,columnDefinition = "boolean default false")
    private boolean borrowed;
}
