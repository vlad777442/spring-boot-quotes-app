package com.kameleoon.quotesmanager.controller;

import com.kameleoon.quotesmanager.model.User;
import com.kameleoon.quotesmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/users")
    List<User> all() {
        return userRepository.findAll();
    }

//    @GetMapping("/users")
//    List<User> all() {
//        return repository.findAll();
//    }
}
