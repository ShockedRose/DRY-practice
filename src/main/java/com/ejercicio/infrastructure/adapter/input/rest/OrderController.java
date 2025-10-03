package com.ejercicio.infrastructure.adapter.input.rest;

import com.ejercicio.application.dto.OrderDTO;
import com.ejercicio.application.usecase.ProcessOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * Controlador REST para órdenes
 * SOLID - SRP: Solo maneja requests HTTP de órdenes
 * SOLID - DIP: Depende del caso de uso
 * DRY: No duplica lógica de validación o procesamiento
 */
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final ProcessOrderUseCase processOrderUseCase;

    /**
     * Procesa una nueva orden
     * DRY: Toda la lógica está en el caso de uso
     */
    @PostMapping
    public ResponseEntity<OrderDTO> processOrder(@Valid @RequestBody OrderDTO orderDTO) {
        OrderDTO processedOrder = processOrderUseCase.processOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(processedOrder);
    }

    /**
     * Endpoint de conveniencia para órdenes online
     */
    @PostMapping("/online")
    public ResponseEntity<OrderDTO> processOnlineOrder(@RequestParam double total) {
        OrderDTO orderDTO = OrderDTO.builder()
                .total(total)
                .orderType("ONLINE")
                .build();
        return processOrder(orderDTO);
    }

    /**
     * Endpoint de conveniencia para órdenes en tienda
     */
    @PostMapping("/in-store")
    public ResponseEntity<OrderDTO> processInStoreOrder(@RequestParam double total) {
        OrderDTO orderDTO = OrderDTO.builder()
                .total(total)
                .orderType("IN_STORE")
                .build();
        return processOrder(orderDTO);
    }
}
