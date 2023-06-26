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



    public List <Category> getallCategories (){
        return categoryRepo.findAll();
    }
    public Category findCategoryById(Long id){
        return categoryRepo.findById(id).orElseThrow();
    }

    public Category addCategory (Category cours){
        return categoryRepo.save(cours);
    }

    public Category updatCategory (Long id , Category cours){
        return categoryRepo.save(cours);
    }

    public void  deleteCategory(Long id){
        categoryRepo.deleteById(id);
    }







}
