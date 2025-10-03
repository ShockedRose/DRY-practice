package com.ejercicio.infrastructure.adapter.output.persistence;

import com.ejercicio.domain.model.User;
import com.ejercicio.domain.port.output.UserRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Implementación en memoria del repositorio de usuarios
 * SOLID - SRP: Solo maneja persistencia de usuarios
 * SOLID - DIP: Implementa UserRepositoryPort del dominio
 */
@Repository
public class InMemoryUserRepository implements UserRepositoryPort {

    private final Map<String, User> storage = new ConcurrentHashMap<>();

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return storage.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public User save(User user) {
        storage.put(user.getId(), user);
        return user;
    }

    @Override
    public void deleteById(String id) {
        storage.remove(id);
    }
}
