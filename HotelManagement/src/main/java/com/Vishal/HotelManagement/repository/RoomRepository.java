package com.Vishal.HotelManagement.repository;

import com.Vishal.HotelManagement.model.Room;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
//Derived queries
//    `GET /rooms/available` — Get all available rooms
//- `GET /rooms/type/{type}` — Get all rooms by type (SINGLE/DOUBLE/SUITE)
//- `GET /rooms/floor/{floor}` — Get all rooms on a specific floor
//- `GET /rooms/price/{price}` — Get all rooms cheaper than given price

    List<Room> findByAvailableTrue();
    List<Room> findAllByRoomType(String roomType);
    List<Room> findAllByFloor(int floor);
    List<Room> findByPricePerNightLessThan(double price);

    //@query with JPQL
    @Modifying
    @Transactional
    @Query("UPDATE Room r SET r.pricePerNight=:pricePerNight WHERE r.roomId=:roomId")
    int updatePriceById(@Param("roomId") int roomId,@Param("pricePerNight") double pricePerNight);



}
