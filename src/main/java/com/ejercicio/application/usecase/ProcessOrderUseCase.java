package com.ejercicio.application.usecase;

import com.ejercicio.application.dto.OrderDTO;
import com.ejercicio.application.mapper.OrderMapper;
import com.ejercicio.domain.model.Order;
import com.ejercicio.domain.port.output.OrderRepositoryPort;
import com.ejercicio.domain.port.output.OutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Caso de uso para procesar órdenes
 * SOLID - SRP: Solo procesa órdenes
 * SOLID - DIP: Depende de abstracciones
 * DRY: Centraliza validación y procesamiento de órdenes
 */
@Service
@RequiredArgsConstructor
public class ProcessOrderUseCase {

    private final OrderRepositoryPort orderRepository;
    private final OutputPort outputPort;

    /**
     * Procesa una orden
     * DRY: Validación y procesamiento centralizados
     */
    public OrderDTO processOrder(OrderDTO orderDTO) {
        Order order = OrderMapper.toEntity(orderDTO);
        
        // DRY: Usa métodos del dominio para validación
        validateOrder(order);
        
        // Guarda la orden
        Order savedOrder = orderRepository.save(order);
        
        // Imprime resultado
        String message = String.format("Processing %s order: %.2f", 
                savedOrder.getOrderType().name().toLowerCase().replace('_', '-'), 
                savedOrder.getTotal());
        outputPort.printMessage(message);
        
        return OrderMapper.toDTO(savedOrder);
    }

    /**
     * DRY: Validación centralizada de órdenes
     * Evita lógica duplicada de validación
     */
    private void validateOrder(Order order) {
        if (order.getTotal() < 0) {
            throw new IllegalArgumentException("Total cannot be negative");
        }
        
        if (order.isZeroTotal()) {
            outputPort.printMessage("Warning: Order total is zero");
        }
        
        if (!order.isValidTotal() && !order.isZeroTotal()) {
            throw new IllegalArgumentException("Invalid order total");
        }
    }
}
