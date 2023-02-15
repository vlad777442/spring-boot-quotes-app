package com.kameleoon.quotesmanager.service;

import com.kameleoon.quotesmanager.dto.UserRequestDTO;
import com.kameleoon.quotesmanager.model.User;



public interface UserService {
    UserRequestDTO createUser(UserRequestDTO user);

    User getUserById(Long userId);

}
