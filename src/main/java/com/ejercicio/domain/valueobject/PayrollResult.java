package com.ejercicio.domain.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Value Object para representar resultados de cálculos de nómina
 * DRY: Encapsula todos los datos relacionados con el pago en un solo objeto
 * SOLID - SRP: Solo representa el resultado de un cálculo de nómina
 */
@Getter
@Builder
@AllArgsConstructor
public class PayrollResult {
    private final String employeeName;
    private final double baseSalary;
    private final double bonus;
    private final double deductions;
    private final double total;

    /**
     * DRY: Cálculo del total centralizado
     */
    public static PayrollResult calculate(String employeeName, double baseSalary, double bonus, double deductions) {
        double total = baseSalary + bonus - deductions;
        return new PayrollResult(employeeName, baseSalary, bonus, deductions, total);
    }
}
