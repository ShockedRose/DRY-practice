package com.ejercicio.infrastructure.adapter.input.rest;

import com.ejercicio.application.dto.UserDTO;
import com.ejercicio.application.usecase.ManageUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * Controlador REST para gestión de usuarios
 * SOLID - SRP: Solo maneja requests HTTP de usuarios
 * SOLID - DIP: Depende de abstracciones
 * DRY: Toda la lógica está en el caso de uso
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final ManageUserUseCase manageUserUseCase;

    /**
     * Crea un nuevo usuario
     */
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUser = manageUserUseCase.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /**
     * Actualiza un usuario existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable String id,
            @Valid @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        UserDTO updatedUser = manageUserUseCase.updateUser(userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Obtiene un usuario por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        UserDTO user = manageUserUseCase.getUserById(id);
        return ResponseEntity.ok(user);
    }
}
