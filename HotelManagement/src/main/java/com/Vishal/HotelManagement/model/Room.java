package com.Vishal.HotelManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name="rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

//    @Column(nullable = false)
    private String roomNumber;

//    @Column(nullable = false)
    private String roomType;

//    @Column(nullable = false)
    private double pricePerNight;

    @Column(columnDefinition = "boolean default true")
    private boolean available;
    private int floor;


}
