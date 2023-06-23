package com.example.pfltestback.service;

import com.example.pfltestback.entity.Book;
import com.example.pfltestback.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    private BookRepo bookRepo;

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }
    public Book findByTitle(String title) {
        return bookRepo.findByTitle(title).get();
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
}
