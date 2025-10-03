package com.ejercicio.application.usecase;

import com.ejercicio.domain.port.output.OutputPort;
import com.ejercicio.domain.valueobject.ReportStatistics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso para generar reportes
 * SOLID - SRP: Solo genera reportes
 * SOLID - OCP: Fácil de extender con nuevos tipos de reportes
 * DRY: Centraliza la lógica común de generación de reportes
 */
@Service
@RequiredArgsConstructor
public class GenerateReportUseCase {

    private final OutputPort outputPort;

    /**
     * Genera reporte de ventas
     * DRY: Usa método común generateReport
     */
    public void generateSalesReport(String title, List<Double> sales) {
        generateReport(title, sales, "Sale");
    }

    /**
     * Genera reporte de inventario
     * DRY: Usa método común generateReport
     */
    public void generateInventoryReport(String title, List<Integer> inventory) {
        generateReport(title, inventory, "Item");
    }

    /**
     * DRY: Método genérico que centraliza la lógica de generación de reportes
     * Evita duplicar código entre diferentes tipos de reportes
     * SOLID - OCP: Para añadir nuevos tipos de reporte, solo se crea un nuevo método público
     */
    private <T extends Number> void generateReport(String title, List<T> items, String itemLabel) {
        outputPort.printMessage("Report: " + title);
        outputPort.printMessage("-------------------");
        
        // Imprime cada item
        for (int i = 0; i < items.size(); i++) {
            outputPort.printMessage(String.format("%s #%d: %s", itemLabel, i + 1, items.get(i)));
        }
        
        // DRY: Usa Value Object para calcular estadísticas
        ReportStatistics stats = ReportStatistics.calculate(items);
        
        outputPort.printMessage("-------------------");
        outputPort.printMessage(String.format("Total %ss: %.2f", itemLabel, stats.getTotal()));
        outputPort.printMessage(String.format("Average %s: %.2f", itemLabel, stats.getAverage()));
        outputPort.printMessage(String.format("Count: %d", stats.getCount()));
    }
}
