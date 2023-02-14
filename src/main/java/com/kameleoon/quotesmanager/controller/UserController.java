package com.kameleoon.quotesmanager.controller;

import com.kameleoon.quotesmanager.model.Quote;
import com.kameleoon.quotesmanager.model.User;
import com.kameleoon.quotesmanager.repository.UserRepository;
import com.kameleoon.quotesmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public String hello() {
        return "Welcome to the Quote Application";
    }

    @GetMapping("/users")
    List<User> all() {
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public User createQuote(@RequestBody User user) {
        return userService.createUser(user);
    }

//    @GetMapping("/users")
//    List<User> all() {
//        return repository.findAll();
//    }
}
