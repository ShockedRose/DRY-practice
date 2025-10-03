package com.ejercicio.domain.port.output;

import com.ejercicio.domain.model.User;
import java.util.Optional;

/**
 * Puerto de salida para el repositorio de usuarios
 * SOLID - DIP: Inversión de dependencias
 * SOLID - ISP: Interface segregada con operaciones específicas
 */
public interface UserRepositoryPort {
    Optional<User> findById(String id);
    Optional<User> findByEmail(String email);
    User save(User user);
    void deleteById(String id);
}
