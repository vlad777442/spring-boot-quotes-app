package com.kameleoon.quotesmanager.controller;

import com.kameleoon.quotesmanager.dto.QuoteRequestDTO;
import com.kameleoon.quotesmanager.dto.UserRequestDTO;

public class TestData {
    public static final UserRequestDTO user1 = UserRequestDTO.builder()
            .name("Tom")
            .email("tom@cruise.com")
            .password("warnergroup")
            .build();

    public static final UserRequestDTO user2 = UserRequestDTO.builder()
            .name("Sophia")
            .email("sophia@example.com")
            .password("universal")
            .build();

    public static final UserRequestDTO user3 = UserRequestDTO.builder()
            .name("Alex")
            .email("alex@example.com")
            .password("stoneage")
            .build();



    public static final QuoteRequestDTO quote1 = QuoteRequestDTO.builder()
            .content("This is 1 quote of the day")
            .build();


    public static final QuoteRequestDTO quote2 = QuoteRequestDTO.builder()
            .content("The greatest glory in living lies not in never falling, " +
            "but in rising every time we fall.")
            .build();

    public static final QuoteRequestDTO quote3 = QuoteRequestDTO.builder()
            .content("The way to get started is to quit talking and begin doing.")
            .build();

}
