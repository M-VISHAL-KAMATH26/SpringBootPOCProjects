package com.demo.library.service;

import com.demo.library.exception.BookAlreadyBorrowedExeption;
import com.demo.library.exception.ResourceNotFoundException;
import com.demo.library.model.Book;
import com.demo.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepo;

    public Book getBookById(Long bookId){
        return bookRepo.findById(bookId).orElseThrow(()->new ResourceNotFoundException("book not found with id " +bookId));
    }

    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    public void postBook(Book book){
         bookRepo.save(book);
    }

    public void borrowBook(Long bookId){
        Book book=bookRepo.findById(bookId).orElseThrow(()=>new ResourceNotFoundException("book is not found with id"+bookId));

        if(book.isBorrowed()){
            throw new BookAlreadyBorrowedExeption("book with id "+bookId+" is already borrowed");
        }
        book.setBorrowed(true);
        bookRepo.save(book);
    }
}
