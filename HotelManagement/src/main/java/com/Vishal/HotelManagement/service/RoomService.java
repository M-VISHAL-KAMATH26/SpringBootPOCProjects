package com.Vishal.HotelManagement.service;

import com.Vishal.HotelManagement.model.Room;
import com.Vishal.HotelManagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomrepo;

    //for adding room
    public void addRoom(Room room) {
        roomrepo.save(room);
    }
    //for fetching all rooms
    public List<Room> getRooms(){
        return roomrepo.findAll();
    }

    //for getting room by id
    public Room getRoomById(int roomId){
        return roomrepo.findById(roomId).orElse(new Room());
    }

    //for updating the room
    public void updateRoom(Room room){
        roomrepo.save(room);
    }

    public void deleteRoomById(int roomId){
        roomrepo.deleteById(roomId);
    }

    public List<Room> getAvailableRoom(){
       return roomrepo.findByAvailableTrue();
    }

    public List<Room> getRoomByPrice( double price){
        return roomrepo.findByPricePerNightLessThan(price);
    }

    public void updateRoomById(int roomId,double pricePerNight){
        roomrepo.updatePriceById(roomId,pricePerNight);
    }
}
