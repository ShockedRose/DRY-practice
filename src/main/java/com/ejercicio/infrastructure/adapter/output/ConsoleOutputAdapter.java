package com.ejercicio.infrastructure.adapter.output;

import com.ejercicio.domain.port.output.OutputPort;
import com.ejercicio.domain.valueobject.PayrollResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Adaptador para salida por consola
 * SOLID - SRP: Solo maneja la salida de datos
 * SOLID - DIP: Implementa OutputPort del dominio
 * DRY: Centraliza la lógica de impresión que estaba dispersa
 */
@Slf4j
@Component
public class ConsoleOutputAdapter implements OutputPort {

    /**
     * DRY: Formato de impresión de nómina centralizado
     */
    @Override
    public void printPayrollResult(PayrollResult result) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║       PAYROLL SUMMARY                ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ Employee: %-26s ║%n", result.getEmployeeName());
        System.out.printf("║ Base Salary: $%-21.2f ║%n", result.getBaseSalary());
        System.out.printf("║ Bonus: $%-27.2f ║%n", result.getBonus());
        System.out.printf("║ Deductions: $%-22.2f ║%n", result.getDeductions());
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ TOTAL: $%-27.2f ║%n", result.getTotal());
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println();

        log.info("Payroll processed for: {}, Total: {}", 
                result.getEmployeeName(), result.getTotal());
    }

    /**
     * DRY: Impresión simple de mensajes
     */
    @Override
    public void printMessage(String message) {
        System.out.println(message);
        log.info(message);
    }
}
