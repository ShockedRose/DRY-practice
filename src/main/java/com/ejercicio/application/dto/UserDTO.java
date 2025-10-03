package com.ejercicio.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para transferir datos de usuarios
 * DRY: Centraliza la estructura de datos de usuario para las APIs
 * SOLID - SRP: Solo transferencia de datos
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String email;
}
