# Proyecto Ejercicio 2 - SOLID & DRY Principles

## 📋 Descripción

Proyecto refactorizado aplicando **principios SOLID** y **DRY** usando **Spring Boot**, **Gradle** y **Arquitectura Limpia (Clean Architecture)**.

## 🏗️ Arquitectura

El proyecto sigue la arquitectura limpia (Clean Architecture) con las siguientes capas:

```
src/main/java/com/ejercicio/
├── domain/                          # Capa de Dominio
│   ├── model/                       # Entidades del dominio
│   │   ├── Employee.java
│   │   ├── User.java
│   │   ├── Order.java
│   │   └── OrderType.java
│   ├── valueobject/                 # Objetos de valor
│   │   ├── PayrollResult.java
│   │   └── ReportStatistics.java
│   └── port/                        # Puertos (interfaces)
│       └── output/
│           ├── NotificationPort.java
│           ├── EmployeeRepositoryPort.java
│           ├── UserRepositoryPort.java
│           ├── OrderRepositoryPort.java
│           └── OutputPort.java
│
├── application/                     # Capa de Aplicación
│   ├── usecase/                     # Casos de uso
│   │   ├── ProcessPayrollUseCase.java
│   │   ├── SendNotificationUseCase.java
│   │   ├── ManageUserUseCase.java
│   │   ├── ProcessOrderUseCase.java
│   │   └── GenerateReportUseCase.java
│   ├── dto/                         # DTOs
│   │   ├── EmployeeDTO.java
│   │   ├── UserDTO.java
│   │   ├── OrderDTO.java
│   │   └── NotificationDTO.java
│   └── mapper/                      # Mappers
│       ├── EmployeeMapper.java
│       ├── UserMapper.java
│       └── OrderMapper.java
│
└── infrastructure/                  # Capa de Infraestructura
    ├── adapter/
    │   ├── input/
    │   │   └── rest/               # Controladores REST
    │   │       ├── PayrollController.java
    │   │       ├── NotificationController.java
    │   │       ├── UserController.java
    │   │       ├── OrderController.java
    │   │       └── ReportController.java
    │   └── output/
    │       ├── notification/       # Adaptadores de notificación
    │       │   ├── EmailNotificationAdapter.java
    │       │   ├── SmsNotificationAdapter.java
    │       │   └── PushNotificationAdapter.java
    │       ├── persistence/        # Repositorios
    │       │   ├── InMemoryEmployeeRepository.java
    │       │   ├── InMemoryUserRepository.java
    │       │   └── InMemoryOrderRepository.java
    │       └── ConsoleOutputAdapter.java
    ├── config/                     # Configuraciones
    │   └── WebConfig.java
    └── exception/                  # Manejo de excepciones
        └── GlobalExceptionHandler.java
```

## 🎯 Principios SOLID Aplicados

### 1. **SRP (Single Responsibility Principle)**
- Cada clase tiene una única responsabilidad
- Los casos de uso manejan una única operación de negocio
- Los controladores solo gestionan HTTP requests/responses
- Los adaptadores solo implementan una interfaz específica

### 2. **OCP (Open/Closed Principle)**
- Sistema abierto a extensión mediante nuevas implementaciones de interfaces
- Cerrado a modificación: añadir nuevos tipos de notificación no requiere cambiar código existente
- Uso de Strategy pattern para notificaciones

### 3. **LSP (Liskov Substitution Principle)**
- Todas las implementaciones de `NotificationPort` son intercambiables
- Los repositorios pueden sustituirse sin afectar la lógica de negocio

### 4. **ISP (Interface Segregation Principle)**
- Interfaces pequeñas y específicas (`NotificationPort`, `OutputPort`)
- Los clientes no dependen de métodos que no usan

### 5. **DIP (Dependency Inversion Principle)**
- El dominio define las interfaces (ports)
- La infraestructura implementa las interfaces
- Las capas superiores no dependen de las inferiores

## 🔄 Principio DRY Aplicado

- **Validaciones centralizadas**: Lógica de validación en casos de uso, no duplicada
- **Métodos reutilizables**: `processPayroll()`, `validateUser()`, `buildMessage()`
- **Value Objects**: `PayrollResult` y `ReportStatistics` encapsulan cálculos comunes
- **Mappers**: Conversión entre entidades y DTOs centralizada
- **Constantes**: Eliminación de números mágicos
- **Manejo de errores**: Exception handler global

## 🚀 Tecnologías

- **Java 17**
- **Spring Boot 3.1.5**
- **Gradle**
- **Lombok** (reducir boilerplate)
- **SLF4J** (logging)

## 📦 Compilar y Ejecutar

### Compilar el proyecto:
```bash
./gradlew build
```

### Ejecutar la aplicación:
```bash
./gradlew bootRun
```

La aplicación estará disponible en: `http://localhost:8080`

## 🔌 Endpoints API

### Nóminas (Payroll)
- `POST /api/payroll/monthly` - Procesar nómina mensual
- `POST /api/payroll/annual` - Procesar nómina anual

### Notificaciones
- `POST /api/notifications` - Enviar notificación (body: NotificationDTO)
- `POST /api/notifications/email?to=...&subject=...&message=...` - Enviar email
- `POST /api/notifications/sms?phone=...&message=...` - Enviar SMS
- `POST /api/notifications/push?deviceToken=...&message=...` - Enviar push

### Usuarios
- `POST /api/users` - Crear usuario
- `PUT /api/users/{id}` - Actualizar usuario
- `GET /api/users/{id}` - Obtener usuario

### Órdenes
- `POST /api/orders` - Procesar orden
- `POST /api/orders/online?total=...` - Procesar orden online
- `POST /api/orders/in-store?total=...` - Procesar orden en tienda

### Reportes
- `POST /api/reports/sales?title=...` - Generar reporte de ventas (body: List<Double>)
- `POST /api/reports/inventory?title=...` - Generar reporte de inventario (body: List<Integer>)

## 📝 Ejemplos de Uso

### Procesar nómina mensual:
```bash
curl -X POST http://localhost:8080/api/payroll/monthly
```

### Enviar email:
```bash
curl -X POST "http://localhost:8080/api/notifications/email?to=user@example.com&subject=Hello&message=Test"
```

### Crear usuario:
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","email":"john@example.com"}'
```

### Procesar orden online:
```bash
curl -X POST "http://localhost:8080/api/orders/online?total=150.50"
```

## 💡 Mejoras Implementadas

1. **Separación de responsabilidades**: Cada componente tiene un propósito específico
2. **Inyección de dependencias**: Uso de Spring para gestión de dependencias
3. **Validaciones centralizadas**: No duplicadas en múltiples lugares
4. **Logging estructurado**: Uso de SLF4J en lugar de System.out
5. **Manejo de errores**: Global exception handler
6. **DTOs**: Separación entre modelos de dominio y transferencia de datos
7. **Configuración externalizada**: application.yml
8. **API REST bien estructurada**: Endpoints claros y coherentes

## 🔍 Comparación con el Código Original

### Antes:
- Código duplicado en métodos similares
- Responsabilidades mezcladas
- Sin separación de capas
- Validaciones duplicadas
- Sin inyección de dependencias

### Después:
- DRY: Lógica centralizada y reutilizable
- SOLID: Cada clase con responsabilidad única
- Clean Architecture: Capas bien definidas
- Testeable: Inyección de dependencias facilita testing
- Escalable: Fácil añadir nuevas funcionalidades
- Mantenible: Código organizado y documentado

## 📚 Referencias

- [Clean Architecture - Robert C. Martin](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [SOLID Principles](https://en.wikipedia.org/wiki/SOLID)
- [DRY Principle](https://en.wikipedia.org/wiki/Don%27t_repeat_yourself)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
