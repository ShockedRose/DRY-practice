package com.ejercicio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Entidad Employee del dominio
 * SOLID - SRP (Single Responsibility Principle): 
 * Esta clase solo representa un empleado y sus atributos, no tiene lógica de negocio adicional
 */
@Getter
@Builder
@AllArgsConstructor
public class Employee {
    private final String id;
    private final String name;
    private final double baseSalary;
    private final double monthlyBonus;
    private final double annualBonus;
    private final double monthlyDeductions;
    private final double annualDeductions;

    /**
     * DRY: Método reutilizable para calcular salario con cualquier multiplicador
     */
    public double calculateSalary(int multiplier) {
        return baseSalary * multiplier;
    }

    /**
     * DRY: Método reutilizable para obtener bonificación según tipo
     */
    public double getBonus(boolean isMonthly) {
        return isMonthly ? monthlyBonus : annualBonus;
    }

    /**
     * DRY: Método reutilizable para obtener deducciones según tipo
     */
    public double getDeductions(boolean isMonthly) {
        return isMonthly ? monthlyDeductions : annualDeductions;
    }
}
