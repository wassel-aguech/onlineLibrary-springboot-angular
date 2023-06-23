package com.example.pfltestback.service;


import com.example.pfltestback.entity.Role;
import com.example.pfltestback.entity.User;
import com.example.pfltestback.repository.UserRepo;
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

    public User editUserRole(Integer userId, Role newRole) {
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setRole(newRole); // Update user role
            return userRepo.save(user);
        } else {
            // Throw an exception or handle error for user not found
            throw new RuntimeException("User not found with ID: " + userId);
        }
    }
}
