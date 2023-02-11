package com.kameleoon.quotesmanager.controller;

import com.kameleoon.quotesmanager.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @GetMapping("/")
    public String hello() {
        return "Hello world";
    }

//    @GetMapping("/users")
//    List<User> all() {
//        return repository.findAll();
//    }
}
