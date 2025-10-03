package com.ejercicio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Entidad Order del dominio
 * SOLID - SRP: Representa una orden con sus atributos básicos
 */
@Getter
@Builder
@AllArgsConstructor
public class Order {
    private final String id;
    private final double total;
    private final OrderType orderType;

    /**
     * DRY: Validación centralizada del total
     */
    public boolean isValidTotal() {
        return total > 0;
    }

    /**
     * DRY: Verificación si el total es cero
     */
    public boolean isZeroTotal() {
        return total == 0;
    }
}
