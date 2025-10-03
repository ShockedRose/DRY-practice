package com.ejercicio.domain.port.output;

import com.ejercicio.domain.model.Order;
import java.util.Optional;

/**
 * Puerto de salida para el repositorio de órdenes
 * SOLID - DIP: El dominio no depende de detalles de implementación
 * SOLID - ISP: Métodos específicos para Order
 */
public interface OrderRepositoryPort {
    Optional<Order> findById(String id);
    Order save(Order order);
    void deleteById(String id);
}
