package com.kameleoon.quotesmanager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
    @NotBlank(message = "Login should not be empty")
    String name;
    @Email(message = "Invalid email")
    String email;
    @NotBlank(message = "Password should not be empty")
    String password;
}
