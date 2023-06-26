package com.example.cours.back.controller;


import com.example.cours.back.model.Role;
import com.example.cours.back.model.User;
import com.example.cours.back.repository.UserRepo;
import com.example.cours.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableAutoConfiguration
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/User")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
   private UserRepo userRepo;

    @PostMapping("/add")
    public User addNewUClient(@RequestBody User user){
       return  userService.addUser(user, Role.NORMAL);
    }

    @PostMapping("/addSubscriberUser")
    public User addNewSubscriberUser(@RequestBody User user) {
        return userService.addUser(user, Role.NORMAL);
    }

    @GetMapping("/findByEmail")
    public User findByEmail(@RequestParam("email") String email){
     return  userService.findByEmail(email);
    }
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PutMapping("/{id}/decreaseDownloadsRemaining")
    public void decreaseDownloadsRemaining(@PathVariable Integer id) {
        User user = userRepo.findById(Long.valueOf(id)).orElseThrow(() -> new IllegalArgumentException("User not found"));
        int downloadsRemaining = user.getDownloadsRemaining();
        if (downloadsRemaining > 0) {
            user.setDownloadsRemaining(downloadsRemaining - 1);
            userRepo.save(user);
        } else {
            throw new IllegalStateException("No downloads remaining for the user");
        }
    }


}
