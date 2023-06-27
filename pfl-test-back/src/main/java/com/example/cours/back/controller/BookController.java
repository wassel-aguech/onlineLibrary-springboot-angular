package com.example.cours.back.controller;

import com.example.cours.back.model.Book;
import com.example.cours.back.service.CategoryService;
import com.example.cours.back.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Book")
public class BookController {

    @Autowired
    private BookService bookService;


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Book> getall (){

        return bookService.getAllBook();
    }
    @GetMapping("/find/{id}")
    public Optional <Book> getBookById(@PathVariable("id") Long id){
        return bookService.getBookById(id);
    }

    @PostMapping("/add")
    public Book addBook (@RequestBody Book book){
        return bookService.addBook(book);

    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public  void deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
    }



}
