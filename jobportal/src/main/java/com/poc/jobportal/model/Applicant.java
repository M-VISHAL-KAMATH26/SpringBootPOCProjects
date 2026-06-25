package com.poc.jobportal.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long applicantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    private String skills;

    private LocalDateTime createdAt;
}
