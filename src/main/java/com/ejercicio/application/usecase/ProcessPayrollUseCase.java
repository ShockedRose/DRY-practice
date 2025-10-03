package com.ejercicio.application.usecase;

import com.ejercicio.domain.model.Employee;
import com.ejercicio.domain.port.output.EmployeeRepositoryPort;
import com.ejercicio.domain.port.output.OutputPort;
import com.ejercicio.domain.valueobject.PayrollResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso para procesar nóminas
 * SOLID - SRP: Solo se encarga de procesar nóminas
 * SOLID - DIP: Depende de abstracciones (ports) no de implementaciones
 * DRY: Centraliza la lógica de procesamiento de nóminas que estaba duplicada
 */
@Service
@RequiredArgsConstructor
public class ProcessPayrollUseCase {

    private final EmployeeRepositoryPort employeeRepository;
    private final OutputPort outputPort;

    // Constantes DRY: Evita números mágicos
    private static final int MONTHLY_MULTIPLIER = 1;
    private static final int ANNUAL_MULTIPLIER = 12;

    /**
     * Procesa nómina mensual
     * DRY: Usa método común processPayroll
     */
    public void processMonthlyPayroll() {
        List<Employee> employees = employeeRepository.findAll();
        processPayroll(employees, MONTHLY_MULTIPLIER, true);
    }

    /**
     * Procesa nómina anual
     * DRY: Usa método común processPayroll
     */
    public void processAnnualPayroll() {
        List<Employee> employees = employeeRepository.findAll();
        processPayroll(employees, ANNUAL_MULTIPLIER, false);
    }

    /**
     * DRY: Método privado que centraliza la lógica común de procesamiento
     * Evita duplicación de código entre procesos mensuales y anuales
     */
    private void processPayroll(List<Employee> employees, int salaryMultiplier, boolean isMonthly) {
        employees.forEach(employee -> {
            double baseSalary = employee.calculateSalary(salaryMultiplier);
            double bonus = employee.getBonus(isMonthly);
            double deductions = employee.getDeductions(isMonthly);

            // DRY: Usa Value Object para calcular resultado
            PayrollResult result = PayrollResult.calculate(
                    employee.getName(),
                    baseSalary,
                    bonus,
                    deductions
            );

            outputPort.printPayrollResult(result);
        });
    }
}
