package com.example.cours.back.service;


import com.example.cours.back.model.Book;
import com.example.cours.back.repository.CategoryRepo;
import com.example.cours.back.repository.BookRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {


    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Book> getAllBook(){
        return bookRepo.findAll();
    }


    public Optional <Book> getBookById(Long id){
        return bookRepo.findById(id);
    }
    public Book addBook(Book book){
        return bookRepo.save(book);
    }

    public Book updateBook(Book book){
        return bookRepo.save(book);
    }

    public void deleteBook(Long id){
        if(bookRepo.findById(id).isPresent()){
            bookRepo.deleteById(id);

    System.out.println( " le book de id " +id + "  est suprime ");
        }  else {
        throw new EntityNotFoundException("La book avec l'ID " + id + " n'existe pas.");
    }
    }





}
