package com.example.cours.back.controller;


import com.example.cours.back.model.Role;
import com.example.cours.back.model.User;
import com.example.cours.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
       return userService.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public  void deleteuser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }


    @GetMapping("/findByEmail")
    public User findByEmail(@RequestParam("email") String email){
        return userService.findByEmail(email);
    }
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{userId}/editRole")
    public ResponseEntity<User> editUserRole(@PathVariable Long userId, @RequestParam Role newRole) {
            User updatedUser = userService.editUserRole(userId, newRole);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

}
