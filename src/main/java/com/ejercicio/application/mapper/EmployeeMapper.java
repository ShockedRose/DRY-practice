package com.ejercicio.application.mapper;

import com.ejercicio.application.dto.EmployeeDTO;
import com.ejercicio.domain.model.Employee;

/**
 * Mapper para convertir entre Employee y EmployeeDTO
 * DRY: Centraliza la lógica de conversión entre entidad y DTO
 * SOLID - SRP: Solo se encarga de mapear datos
 */
public class EmployeeMapper {

    /**
     * DRY: Conversión centralizada de entidad a DTO
     */
    public static EmployeeDTO toDTO(Employee employee) {
        if (employee == null) {
            return null;
        }
        return EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .baseSalary(employee.getBaseSalary())
                .monthlyBonus(employee.getMonthlyBonus())
                .annualBonus(employee.getAnnualBonus())
                .monthlyDeductions(employee.getMonthlyDeductions())
                .annualDeductions(employee.getAnnualDeductions())
                .build();
    }

    /**
     * DRY: Conversión centralizada de DTO a entidad
     */
    public static Employee toEntity(EmployeeDTO dto) {
        if (dto == null) {
            return null;
        }
        return Employee.builder()
                .id(dto.getId())
                .name(dto.getName())
                .baseSalary(dto.getBaseSalary())
                .monthlyBonus(dto.getMonthlyBonus())
                .annualBonus(dto.getAnnualBonus())
                .monthlyDeductions(dto.getMonthlyDeductions())
                .annualDeductions(dto.getAnnualDeductions())
                .build();
    }
}
