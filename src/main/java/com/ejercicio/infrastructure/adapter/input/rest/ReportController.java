package com.ejercicio.infrastructure.adapter.input.rest;

import com.ejercicio.application.usecase.GenerateReportUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para reportes
 * SOLID - SRP: Solo maneja requests HTTP de reportes
 * SOLID - DIP: Depende del caso de uso
 * DRY: Delega generación de reportes al caso de uso
 */
@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final GenerateReportUseCase generateReportUseCase;

    /**
     * Genera reporte de ventas
     */
    @PostMapping("/sales")
    public ResponseEntity<String> generateSalesReport(
            @RequestParam String title,
            @RequestBody List<Double> sales) {
        generateReportUseCase.generateSalesReport(title, sales);
        return ResponseEntity.ok("Sales report generated successfully");
    }

    /**
     * Genera reporte de inventario
     */
    @PostMapping("/inventory")
    public ResponseEntity<String> generateInventoryReport(
            @RequestParam String title,
            @RequestBody List<Integer> inventory) {
        generateReportUseCase.generateInventoryReport(title, inventory);
        return ResponseEntity.ok("Inventory report generated successfully");
    }
}
