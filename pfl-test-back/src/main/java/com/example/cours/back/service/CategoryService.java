package com.example.cours.back.service;

import com.example.cours.back.model.Category;
import com.example.cours.back.model.Book;
import com.example.cours.back.repository.CategoryRepo;
import com.example.cours.back.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private BookRepo bookRepo;


    public List <Category> getallCategory (){
        return categoryRepo.findAll();
    }
    public Category findCategoryById(Long id){
        return categoryRepo.findById(id).orElseThrow();
    }

    public Category addCategory (Category category){
        return categoryRepo.save(category);
    }

    public Category updateCategory (Long id , Category category){
        return categoryRepo.save(category);
    }

    public void  deleteCategory(Long id){
        categoryRepo.deleteById(id);
    }



    public void affectBooktoCategory(Long BookId, Long CategoryId) {

        Category category = categoryRepo.findById(BookId).get();
        Book book = bookRepo.findById(CategoryId).get();
        book.setCategory(category);

        categoryRepo.save(category);

    }





}
