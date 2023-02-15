package com.kameleoon.quotesmanager.service;

import com.kameleoon.quotesmanager.dto.UserRequestDTO;
import com.kameleoon.quotesmanager.dto.UserResponseDTO;
import com.kameleoon.quotesmanager.mapper.UserMapper;
import com.kameleoon.quotesmanager.model.User;
import com.kameleoon.quotesmanager.repository.UserRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserRequestDTO createUser(UserRequestDTO userDto) {
        try {
            User user = userRepository.save(userMapper.toUser(userDto));
            return userMapper.toUserRequestDTO(user);
        }
        catch (
        DataIntegrityViolationException e) {
            throw new ValidationException(String.format("User already exist"));
        }


    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.getReferenceById(userId);
    }

//    @Override
//    public List<UserResponseDTO> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public UserResponseDTO getUserById(Long id) {
//        return userRepository.getReferenceById(id);
//    }
//
//    @Override
//    public void deleteUserById(Long id) {
//        userRepository.deleteById(id);
//    }
}
