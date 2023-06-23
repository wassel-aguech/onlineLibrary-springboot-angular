package com.example.pfltestback.service;


import com.example.pfltestback.entity.Category;
import com.example.pfltestback.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {


    @Autowired
    private CategoryRepo categoryRepo;


    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

}
