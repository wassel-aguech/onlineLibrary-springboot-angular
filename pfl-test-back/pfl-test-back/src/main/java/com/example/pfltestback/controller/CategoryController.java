package com.example.pfltestback.controller;

import com.example.pfltestback.entity.Category;
import com.example.pfltestback.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Category")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @PostMapping("/addcategory")
    public Category addCategy(@RequestBody Category category){
        Category newCategory = categoryService.addCategory(category);
        return newCategory;
    }

    @GetMapping("/getallcategory")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategories();
    }


}
