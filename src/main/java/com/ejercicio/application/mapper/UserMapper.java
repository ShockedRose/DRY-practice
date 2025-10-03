package com.ejercicio.application.mapper;

import com.ejercicio.application.dto.UserDTO;
import com.ejercicio.domain.model.User;

/**
 * Mapper para User
 * DRY: Evita duplicar código de conversión en múltiples lugares
 */
public class UserMapper {

    public static UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static User toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }
}
