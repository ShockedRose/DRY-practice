package com.ejercicio.infrastructure.adapter.output.persistence;

import com.ejercicio.domain.model.Employee;
import com.ejercicio.domain.port.output.EmployeeRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Implementación en memoria del repositorio de empleados
 * SOLID - SRP: Solo maneja persistencia de empleados
 * SOLID - DIP: Implementa la interfaz del dominio
 * DRY: Centraliza la lógica de persistencia
 * 
 * En un sistema real, esto se conectaría a una base de datos usando JPA/Hibernate
 */
@Repository
public class InMemoryEmployeeRepository implements EmployeeRepositoryPort {

    // DRY: Almacenamiento centralizado thread-safe
    private final Map<String, Employee> storage = new ConcurrentHashMap<>();

    public InMemoryEmployeeRepository() {
        // Datos de ejemplo para testing
        initializeTestData();
    }

    @Override
    public Optional<Employee> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Employee save(Employee employee) {
        storage.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public void deleteById(String id) {
        storage.remove(id);
    }

    /**
     * DRY: Inicialización de datos de prueba centralizada
     */
    private void initializeTestData() {
        Employee emp1 = Employee.builder()
                .id("1")
                .name("Juan Pérez")
                .baseSalary(3000.0)
                .monthlyBonus(200.0)
                .annualBonus(2500.0)
                .monthlyDeductions(150.0)
                .annualDeductions(1800.0)
                .build();

        Employee emp2 = Employee.builder()
                .id("2")
                .name("María García")
                .baseSalary(3500.0)
                .monthlyBonus(250.0)
                .annualBonus(3000.0)
                .monthlyDeductions(175.0)
                .annualDeductions(2100.0)
                .build();

        save(emp1);
        save(emp2);
    }
}
