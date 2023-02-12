package com.kameleoon.quotesmanager.service;

import com.kameleoon.quotesmanager.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUserById(Long id);
}
