package com.instagram.instagramcrud.rest;

import com.instagram.instagramcrud.entity.User;
import com.instagram.instagramcrud.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // expose "/users" and return a list of users
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    // add mapping for GET /users/{userId}
    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        User theUser = userService.findById(userId);

        if (theUser == null) {
            throw new RuntimeException("User id not found: " + userId);
        }

        return theUser;
    }

    @PostMapping
    public User addUser(@RequestBody User theUser) {
        User dbUser = userService.save(theUser);
        return dbUser;
    }

    // Update existing user
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User theUser) {
        User existingUser = userService.findById(userId);

        if (existingUser == null) {
            throw new RuntimeException("User id not found: " + userId);
        }

        existingUser.setUserName(theUser.getUserName());
        existingUser.setEmail(theUser.getEmail());
        existingUser.setPassword(theUser.getPassword());

        return userService.save(existingUser);
    }

    // Delete a user
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        User existingUser = userService.findById(userId);

        if (existingUser == null) {
            throw new RuntimeException("User id not found: " + userId);
        }

        userService.deleteById(userId);
    }
}
