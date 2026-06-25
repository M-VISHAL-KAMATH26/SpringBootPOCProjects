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
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long jobId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String company;

    private  String location;

    @Column(nullable = false)
    private double salary;

    @Enumerated(EnumType.STRING)
    private JobStatus status;

    private LocalDateTime date;



}
