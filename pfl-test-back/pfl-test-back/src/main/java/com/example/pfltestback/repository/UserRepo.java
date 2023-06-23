package com.example.pfltestback.repository;

import com.example.pfltestback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo  extends JpaRepository <User , Integer> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}
