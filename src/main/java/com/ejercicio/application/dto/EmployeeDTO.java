package com.ejercicio.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para transferir datos de empleados
 * DRY: Evita exponer directamente las entidades del dominio
 * SOLID - SRP: Solo se encarga de transferir datos entre capas
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private String id;
    private String name;
    private double baseSalary;
    private double monthlyBonus;
    private double annualBonus;
    private double monthlyDeductions;
    private double annualDeductions;
}
