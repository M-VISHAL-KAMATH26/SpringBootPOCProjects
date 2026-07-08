package com.demo.library.controller;

import com.demo.library.model.Book;
import com.demo.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById( @PathVariable Long bookId ){
        return bookService.getBookById(bookId);
    }

    @PostMapping("/books")
    public void postBooks(@Valid @RequestBody Book book){
        bookService.postBook(book);
    }
    @PostMapping("/books/{bookId}/borrow")
    public void borrowBook(@PathVariable Long bookId) {
        bookService.borrowBook(bookId);
    }


}
