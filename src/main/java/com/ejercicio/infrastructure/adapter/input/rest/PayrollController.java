package com.ejercicio.infrastructure.adapter.input.rest;

import com.ejercicio.application.usecase.ProcessPayrollUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para operaciones de nómina
 * SOLID - SRP: Solo maneja requests HTTP relacionados con nóminas
 * SOLID - DIP: Depende de abstracciones (use cases)
 * DRY: Delega toda la lógica de negocio a los casos de uso
 */
@RestController
@RequestMapping("/api/payroll")
@RequiredArgsConstructor
public class PayrollController {

    private final ProcessPayrollUseCase processPayrollUseCase;

    /**
     * Procesa nómina mensual
     * DRY: No duplica lógica de negocio, solo coordina
     */
    @PostMapping("/monthly")
    public ResponseEntity<String> processMonthlyPayroll() {
        processPayrollUseCase.processMonthlyPayroll();
        return ResponseEntity.ok("Monthly payroll processed successfully");
    }

    /**
     * Procesa nómina anual
     * DRY: Reutiliza el caso de uso
     */
    @PostMapping("/annual")
    public ResponseEntity<String> processAnnualPayroll() {
        processPayrollUseCase.processAnnualPayroll();
        return ResponseEntity.ok("Annual payroll processed successfully");
    }
}
