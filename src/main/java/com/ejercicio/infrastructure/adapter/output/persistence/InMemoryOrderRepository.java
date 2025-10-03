package com.ejercicio.infrastructure.adapter.output.persistence;

import com.ejercicio.domain.model.Order;
import com.ejercicio.domain.port.output.OrderRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Implementación en memoria del repositorio de órdenes
 * SOLID - SRP: Solo maneja persistencia de órdenes
 * SOLID - DIP: Implementa OrderRepositoryPort
 */
@Repository
public class InMemoryOrderRepository implements OrderRepositoryPort {

    private final Map<String, Order> storage = new ConcurrentHashMap<>();

    @Override
    public Optional<Order> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Order save(Order order) {
        storage.put(order.getId(), order);
        return order;
    }

    @Override
    public void deleteById(String id) {
        storage.remove(id);
    }
}
