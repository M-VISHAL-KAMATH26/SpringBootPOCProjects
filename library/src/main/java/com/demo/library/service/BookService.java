package com.demo.library.service;

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
        return bookRepo.findById(bookId).orElse(null);
    }

    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    public void postBook(Book book){
         bookRepo.save(book);
    }
}
