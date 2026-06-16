package com.Vishal.HotelManagement.controller;


import com.Vishal.HotelManagement.model.Room;
import com.Vishal.HotelManagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    RoomService service;

    @RequestMapping("/")
    public String home() {
        return "welcome to the Hotel";
    }
    //crud operations
    //add a new room
    @PostMapping("/rooms")
    public ResponseEntity<String> addRoom(@RequestBody  Room room){
        service.addRoom(room);
        return ResponseEntity.ok("sucessfully added rooom");
    }

    //get all the rooms
    @GetMapping("/rooms")
    public List<Room> getRooms(){
        return service.getRooms();
    }
    //get room by id
    @GetMapping("/rooms/{roomId}")
    public Room getRoomById(@PathVariable int  roomId){
        return service.getRoomById(roomId);
    }
    @PutMapping("/rooms")
    public void updateRoom(@RequestBody Room room){
        service.updateRoom(room);
    }

    @DeleteMapping("/rooms/{roomId}")
    public void deleteRoomById(@PathVariable int roomId){
        service.deleteRoomById(roomId);
    }

    @GetMapping("/rooms/available")
    public List<Room> getAvailableRoom(){
        return service.getAvailableRoom();
    }

    @GetMapping("/rooms/{price}")
    public List<Room> getRoomByPrice(@PathVariable double price){
        return service.getRoomByPrice(price);
    }
    @PutMapping("/rooms/{roomId}/price/{price}")
    public void updateRoomById(@PathVariable int roomId,@PathVariable double price){
        service.updateRoomById(roomId,price);
    }

}
