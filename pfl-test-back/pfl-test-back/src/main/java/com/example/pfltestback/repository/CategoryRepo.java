package com.example.pfltestback.repository;

import com.example.pfltestback.entity.Book;
import com.example.pfltestback.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryRepo extends JpaRepository<Category,  Integer> {

}
