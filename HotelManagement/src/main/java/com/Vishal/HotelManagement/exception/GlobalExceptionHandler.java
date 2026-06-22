package com.Vishal.HotelManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.Vishal.HotelManagement.dto.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRoomNotFound(RoomNotFoundException ex){
        ErrorResponse error=new ErrorResponse(ex.getMessage(), LocalDateTime.now(),404);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
