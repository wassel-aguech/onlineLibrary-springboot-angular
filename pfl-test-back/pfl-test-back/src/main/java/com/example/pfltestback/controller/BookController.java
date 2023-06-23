package com.example.pfltestback.controller;


import com.example.pfltestback.entity.Book;
import com.example.pfltestback.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Book")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping("/addbook")
    public Book addNewBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
    @GetMapping("/getallbook")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
}
