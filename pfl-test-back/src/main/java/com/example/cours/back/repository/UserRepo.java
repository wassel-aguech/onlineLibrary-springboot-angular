package com.example.cours.back.repository;

import com.example.cours.back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository <User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);

    Boolean existsByEmail(String email);
}
