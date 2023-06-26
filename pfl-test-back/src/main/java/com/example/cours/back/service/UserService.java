package com.example.cours.back.service;

import com.example.cours.back.model.Book;
import com.example.cours.back.model.Role;
import com.example.cours.back.model.User;
import com.example.cours.back.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public User addUser(User user, Role role) {
        return userRepo.save(user);
    }


    public User findByEmail(String email) {
        return userRepo.findByEmail(email).get();
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }


}



