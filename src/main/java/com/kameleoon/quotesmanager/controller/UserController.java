package com.kameleoon.quotesmanager.controller;

import com.kameleoon.quotesmanager.dto.UserRequestDTO;
import com.kameleoon.quotesmanager.dto.UserResponseDTO;
import com.kameleoon.quotesmanager.model.Quote;
import com.kameleoon.quotesmanager.model.User;
import com.kameleoon.quotesmanager.repository.UserRepository;
import com.kameleoon.quotesmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/")
    public UserRequestDTO createUser(@RequestBody UserRequestDTO user) {
        return userService.createUser(user);
    }


}
