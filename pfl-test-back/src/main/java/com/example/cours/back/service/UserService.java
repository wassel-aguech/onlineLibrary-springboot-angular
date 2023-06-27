package com.example.cours.back.service;

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

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public void  deleteUser(Long id){
        userRepo.deleteById(id);
    }


    public User findByEmail(String email) {
        return userRepo.findByEmail(email).get();
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User editUserRole(Long userId, Role newRole) {
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setRole(newRole);
            return userRepo.save(user);
        } else {
            throw new RuntimeException("User not found with ID: " + userId);
        }
    }
}

