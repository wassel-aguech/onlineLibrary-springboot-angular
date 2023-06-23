package com.example.pfltestback.controller;


import com.example.pfltestback.entity.Role;
import com.example.pfltestback.entity.User;
import com.example.pfltestback.repository.UserRepo;
import com.example.pfltestback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/adduser")
    public User addNewUClient(@RequestBody User user){
        User newUser = userService.addUser(user, Role.NORMAL);
        return newUser;
    }

    @PostMapping("/addSubscriberUser")
    public User addNewSubscriberUser(@RequestBody User user) {
        return userService.addUser(user, Role.NORMAL);
    }

    @GetMapping("/findByEmail")
    public User findByEmail(@RequestParam("email") String email){
        User UserByEmail = userService.findByEmail(email);
        return UserByEmail;
    }
    @GetMapping("/getalluser")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{userId}/editRole")
    public ResponseEntity<User> editUserRole(@PathVariable Integer userId, @RequestParam Role newRole) {
        try {
            User updatedUser = userService.editUserRole(userId, newRole);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/decreaseDownloadsRemaining")
    public void decreaseDownloadsRemaining(@PathVariable Integer id) {
        User user = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        int downloadsRemaining = user.getDownloadsRemaining();
        if (downloadsRemaining > 0) {
            user.setDownloadsRemaining(downloadsRemaining - 1);
            userRepo.save(user);
        } else {
            throw new IllegalStateException("No downloads remaining for the user");
        }
    }


}
