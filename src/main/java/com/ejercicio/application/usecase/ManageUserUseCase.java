package com.ejercicio.application.usecase;

import com.ejercicio.application.dto.UserDTO;
import com.ejercicio.application.mapper.UserMapper;
import com.ejercicio.domain.model.User;
import com.ejercicio.domain.port.output.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Caso de uso para gestionar usuarios
 * SOLID - SRP: Solo maneja operaciones de usuario
 * SOLID - DIP: Depende de abstracciones (UserRepositoryPort)
 * DRY: Centraliza validaciones y operaciones de usuario
 */
@Service
@RequiredArgsConstructor
public class ManageUserUseCase {

    private final UserRepositoryPort userRepository;

    /**
     * Crea un nuevo usuario
     * DRY: Validación centralizada
     */
    public UserDTO createUser(UserDTO userDTO) {
        validateUser(userDTO);
        
        User user = UserMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        
        return UserMapper.toDTO(savedUser);
    }

    /**
     * Actualiza un usuario existente
     * DRY: Reutiliza validación
     */
    public UserDTO updateUser(UserDTO userDTO) {
        validateUser(userDTO);
        
        // Verifica que el usuario existe
        userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userDTO.getId()));
        
        User user = UserMapper.toEntity(userDTO);
        User updatedUser = userRepository.save(user);
        
        return UserMapper.toDTO(updatedUser);
    }

    /**
     * Obtiene un usuario por ID
     */
    public UserDTO getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
        return UserMapper.toDTO(user);
    }

    /**
     * DRY: Validación centralizada de usuario
     * Evita duplicar código de validación en create y update
     */
    private void validateUser(UserDTO userDTO) {
        if (userDTO.getName() == null || userDTO.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (userDTO.getEmail() == null || userDTO.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (!isValidEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email format is invalid");
        }
    }

    /**
     * DRY: Validación de formato de email reutilizable
     */
    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
