package com.example.cours.back.controller;


import com.example.cours.back.model.Category;
import com.example.cours.back.model.Book;
import com.example.cours.back.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@EnableAutoConfiguration
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Category")

public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    @GetMapping("/all")
    public List<Category>  getallCategory (){
        return categoryService.getallCategory();
    }

    @GetMapping("/find/{id}")
    public Category getCategoryById(@PathVariable("id") Long id){
        return categoryService.findCategoryById(id);
    }

    @PostMapping("/add")
    public Category addCategory (@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable("id") Long id , @RequestBody Category category){
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/delete/{id}")
    public  void deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
    }


// affecter une book to category
    @PutMapping("/affectation/{bookId}/{categoryId}")
    @ResponseBody
    public void affectation ( @PathVariable Long bookId,
        @PathVariable Long categoryId){
        categoryService.affectBooktoCategory(bookId,categoryId);

    }

}
