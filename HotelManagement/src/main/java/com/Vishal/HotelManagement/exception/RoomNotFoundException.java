package com.Vishal.HotelManagement.exception;

public class RoomNotFoundException extends RuntimeException{


    public RoomNotFoundException(int roomId){
        super("Room with id "+roomId+" not found.!");
    }

}
