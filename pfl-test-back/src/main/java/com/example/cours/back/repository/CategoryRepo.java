package com.example.cours.back.repository;

import com.example.cours.back.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    Optional<Category> findById(Long id);

}
