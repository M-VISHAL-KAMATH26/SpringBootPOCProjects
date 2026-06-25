package com.poc.jobportal.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleJobNotFound(JobNotFoundException ex){
        ErrorResponse err=new ErrorResponse(404,ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ApplicantNotFound.class)
    public ResponseEntity<ErrorResponse> handleApplicantNotFound(ApplicantNotFound ex){
        ErrorResponse err=new ErrorResponse(404,ex.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }
}
