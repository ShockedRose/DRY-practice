package com.ejercicio.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para transferir datos de órdenes
 * DRY: Estructura reutilizable para comunicación entre capas
 * SOLID - SRP: Solo datos de orden
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String id;
    private double total;
    private String orderType; // "ONLINE" o "IN_STORE"
}
