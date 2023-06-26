package com.example.cours.back.repository;

import com.example.cours.back.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    Optional<Book> findById(Long id);
}
