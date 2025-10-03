package com.ejercicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot
 * 
 * Arquitectura implementada: Clean Architecture (Arquitectura Limpia)
 * - Domain Layer: Entidades, Value Objects, Puertos (interfaces)
 * - Application Layer: Casos de Uso, DTOs, Mappers
 * - Infrastructure Layer: Adaptadores (repositorios, notificaciones, salida)
 * - Presentation Layer: Controladores REST
 * 
 * Principios SOLID aplicados:
 * - SRP (Single Responsibility): Cada clase tiene una única responsabilidad
 * - OCP (Open/Closed): Sistema abierto a extensión, cerrado a modificación
 * - LSP (Liskov Substitution): Implementaciones pueden sustituir sus interfaces
 * - ISP (Interface Segregation): Interfaces pequeñas y específicas
 * - DIP (Dependency Inversion): Dependencia de abstracciones, no de implementaciones
 * 
 * Principio DRY aplicado:
 * - Lógica centralizada y reutilizable
 * - Eliminación de duplicación de código
 * - Métodos y componentes compartidos
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
