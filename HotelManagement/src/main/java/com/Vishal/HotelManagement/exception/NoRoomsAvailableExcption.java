package com.Vishal.HotelManagement.exception;

public class NoRoomsAvailableExcption extends RuntimeException{
    public NoRoomsAvailableExcption(){
        super("No rooms available at the moment");
    }
}
