package com.ejercicio.domain.port.output;

import com.ejercicio.domain.valueobject.PayrollResult;

/**
 * Puerto de salida para imprimir resultados
 * SOLID - ISP: Interface específica para salida de datos
 * SOLID - SRP: Solo se encarga de la salida/presentación de datos
 * DRY: Centraliza la lógica de presentación que antes estaba duplicada
 */
public interface OutputPort {
    void printPayrollResult(PayrollResult result);
    void printMessage(String message);
}
