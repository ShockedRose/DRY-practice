package com.ejercicio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Entidad User del dominio
 * SOLID - SRP: Representa únicamente los datos de un usuario
 */
@Getter
@Builder
@AllArgsConstructor
public class User {
    private final String id;
    private final String name;
    private final String email;
}
