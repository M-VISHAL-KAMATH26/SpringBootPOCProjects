package com.demo.library.exception;

public class BookAlreadyBorrowedExeption extends RuntimeException{
    public BookAlreadyBorrowedExeption(String message){
        super(message);
    }
}
