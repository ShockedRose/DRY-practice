package com.ejercicio.domain.port.output;

import com.ejercicio.domain.model.Employee;
import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para el repositorio de empleados
 * SOLID - DIP: El dominio define la interfaz, la infraestructura la implementa
 * SOLID - ISP: Métodos específicos y necesarios para el manejo de empleados
 */
public interface EmployeeRepositoryPort {
    Optional<Employee> findById(String id);
    List<Employee> findAll();
    Employee save(Employee employee);
    void deleteById(String id);
}
