package com.ejercicio.domain.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Value Object para estadísticas de reportes
 * DRY: Encapsula cálculos estadísticos comunes
 * SOLID - SRP: Solo calcula y almacena estadísticas
 */
@Getter
@Builder
@AllArgsConstructor
public class ReportStatistics {
    private final double total;
    private final double average;
    private final int count;

    /**
     * DRY: Cálculo de estadísticas centralizado y reutilizable
     */
    public static <T extends Number> ReportStatistics calculate(java.util.List<T> items) {
        if (items == null || items.isEmpty()) {
            return new ReportStatistics(0, 0, 0);
        }

        double sum = items.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
        
        return new ReportStatistics(sum, sum / items.size(), items.size());
    }
}
