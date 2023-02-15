package com.kameleoon.quotesmanager.mapper;

import com.kameleoon.quotesmanager.dto.UserRequestDTO;
import com.kameleoon.quotesmanager.dto.UserResponseDTO;
import com.kameleoon.quotesmanager.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequestDTO userRequestDTO);

    UserResponseDTO toUserResponseDTO(User user);

    UserRequestDTO toUserRequestDTO(User user);
}
