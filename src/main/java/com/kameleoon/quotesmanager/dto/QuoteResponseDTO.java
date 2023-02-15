package com.kameleoon.quotesmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuoteResponseDTO {
    private Long id;

    private String content;

    private Date createdAt;

    private Date updatedAt;

    private Integer rating;

    private UserResponseDTO user;

}
