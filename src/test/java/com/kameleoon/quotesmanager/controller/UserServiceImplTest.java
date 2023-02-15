package com.kameleoon.quotesmanager.controller;

import com.kameleoon.quotesmanager.dto.UserRequestDTO;
import com.kameleoon.quotesmanager.model.User;
import com.kameleoon.quotesmanager.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@Transactional
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class UserServiceImplTest {

    @Autowired
    private UserService userService;
    private UserRequestDTO userDto;

    @BeforeEach
    void setUp() {
        userDto = new UserRequestDTO(
                "Tom",
                "tom@cruise.com",
                "warnergroup");
    }
    @Test
    void createUser() {
        userService.createUser(userDto);
        User user = userService.getUserById(1L);
        assertThat(user.getId(), equalTo(1L));
        assertThat(user.getName(), equalTo(userDto.getName()));
        assertThat(user.getEmail(), equalTo(userDto.getEmail()));
    }
}