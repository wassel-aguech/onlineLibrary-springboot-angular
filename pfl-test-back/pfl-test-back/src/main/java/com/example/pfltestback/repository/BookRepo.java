package com.example.pfltestback.repository;

import com.example.pfltestback.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo  extends JpaRepository <Book , Integer> {
    Optional<Book> findByTitle(String title);

}
