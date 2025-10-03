# Guía de Pruebas y Uso - Proyecto SOLID & DRY

## 🚀 Inicio Rápido

### 1. Compilar el proyecto
```bash
./gradlew build
```

### 2. Ejecutar la aplicación
```bash
./gradlew bootRun
```

La aplicación se iniciará en `http://localhost:8080`

## 📋 Ejemplos de Uso con cURL

### 1. Procesamiento de Nóminas

#### Procesar nómina mensual
```bash
curl -X POST http://localhost:8080/api/payroll/monthly
```

**Resultado esperado**: Se procesará la nómina mensual de todos los empleados en el repositorio y se imprimirá en consola.

#### Procesar nómina anual
```bash
curl -X POST http://localhost:8080/api/payroll/annual
```

---

### 2. Notificaciones

#### Enviar Email
```bash
curl -X POST "http://localhost:8080/api/notifications/email?to=john@example.com&subject=Welcome&message=Hello%20World"
```

#### Enviar SMS
```bash
curl -X POST "http://localhost:8080/api/notifications/sms?phone=+1234567890&message=Your%20code%20is%20123456"
```

#### Enviar Push Notification
```bash
curl -X POST "http://localhost:8080/api/notifications/push?deviceToken=abc123xyz&message=New%20update%20available"
```

#### Enviar notificación genérica (JSON)
```bash
curl -X POST http://localhost:8080/api/notifications \
  -H "Content-Type: application/json" \
  -d '{
    "recipient": "user@example.com",
    "subject": "Test Subject",
    "message": "This is a test message",
    "type": "EMAIL"
  }'
```

---

### 3. Gestión de Usuarios

#### Crear usuario
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "id": "user-001",
    "name": "Juan Pérez",
    "email": "juan.perez@example.com"
  }'
```

#### Actualizar usuario
```bash
curl -X PUT http://localhost:8080/api/users/user-001 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Juan Carlos Pérez",
    "email": "juancarlos.perez@example.com"
  }'
```

#### Obtener usuario por ID
```bash
curl -X GET http://localhost:8080/api/users/user-001
```

---

### 4. Procesamiento de Órdenes

#### Procesar orden online
```bash
curl -X POST "http://localhost:8080/api/orders/online?total=250.75"
```

#### Procesar orden en tienda
```bash
curl -X POST "http://localhost:8080/api/orders/in-store?total=180.50"
```

#### Procesar orden completa (JSON)
```bash
curl -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d '{
    "id": "order-001",
    "total": 299.99,
    "orderType": "ONLINE"
  }'
```

---

### 5. Generación de Reportes

#### Generar reporte de ventas
```bash
curl -X POST "http://localhost:8080/api/reports/sales?title=Ventas%20Mensuales" \
  -H "Content-Type: application/json" \
  -d '[1250.50, 2300.75, 1890.25, 3100.00, 2450.50]'
```

#### Generar reporte de inventario
```bash
curl -X POST "http://localhost:8080/api/reports/inventory?title=Stock%20de%20Productos" \
  -H "Content-Type: application/json" \
  -d '[45, 120, 89, 67, 234, 156, 78]'
```

---

## 🧪 Pruebas con Postman

### Colección de Postman

Importa esta colección en Postman para probar todos los endpoints:

```json
{
  "info": {
    "name": "SOLID DRY API",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Payroll",
      "item": [
        {
          "name": "Process Monthly Payroll",
          "request": {
            "method": "POST",
            "url": "http://localhost:8080/api/payroll/monthly"
          }
        },
        {
          "name": "Process Annual Payroll",
          "request": {
            "method": "POST",
            "url": "http://localhost:8080/api/payroll/annual"
          }
        }
      ]
    },
    {
      "name": "Notifications",
      "item": [
        {
          "name": "Send Email",
          "request": {
            "method": "POST",
            "url": {
              "raw": "http://localhost:8080/api/notifications/email?to=test@example.com&subject=Test&message=Hello",
              "query": [
                {"key": "to", "value": "test@example.com"},
                {"key": "subject", "value": "Test"},
                {"key": "message", "value": "Hello"}
              ]
            }
          }
        }
      ]
    }
  ]
}
```

---

## 🔍 Verificación de Logs

Al ejecutar las peticiones, verás en la consola:

### Ejemplo de salida de nómina:
```
╔══════════════════════════════════════╗
║       PAYROLL SUMMARY                ║
╠══════════════════════════════════════╣
║ Employee: Juan Pérez                 ║
║ Base Salary: $3000.00                ║
║ Bonus: $200.00                       ║
║ Deductions: $150.00                  ║
╠══════════════════════════════════════╣
║ TOTAL: $3050.00                      ║
╚══════════════════════════════════════╝
```

### Ejemplo de notificación:
```
✉️ Email sent to: john@example.com
Message: Welcome: Hello World
```

---

## 🐛 Manejo de Errores

### Error de validación (usuario sin nombre):
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "email": "test@example.com"
  }'
```

**Respuesta**:
```json
{
  "timestamp": "2025-10-03T12:00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Invalid name"
}
```

### Error de orden con total negativo:
```bash
curl -X POST "http://localhost:8080/api/orders/online?total=-50"
```

**Respuesta**:
```json
{
  "timestamp": "2025-10-03T12:00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Total cannot be negative"
}
```

---

## 📊 Datos de Prueba Precargados

El sistema viene con 2 empleados precargados para testing:

### Empleado 1:
- **ID**: 1
- **Nombre**: Juan Pérez
- **Salario Base**: $3,000
- **Bono Mensual**: $200
- **Bono Anual**: $2,500
- **Deducciones Mensuales**: $150
- **Deducciones Anuales**: $1,800

### Empleado 2:
- **ID**: 2
- **Nombre**: María García
- **Salario Base**: $3,500
- **Bono Mensual**: $250
- **Bono Anual**: $3,000
- **Deducciones Mensuales**: $175
- **Deducciones Anuales**: $2,100

---

## 🔧 Comandos Útiles de Gradle

### Limpiar build
```bash
./gradlew clean
```

### Compilar sin tests
```bash
./gradlew build -x test
```

### Ver dependencias
```bash
./gradlew dependencies
```

### Ver tareas disponibles
```bash
./gradlew tasks
```

---

## 📝 Notas Importantes

1. **Puerto por defecto**: 8080 (configurable en `application.yml`)
2. **Logging**: Los logs se muestran en consola con nivel DEBUG
3. **Base de datos**: In-memory (datos se pierden al reiniciar)
4. **CORS**: Habilitado para todos los orígenes (solo desarrollo)

---

## 🎯 Ejercicios Prácticos

### Ejercicio 1: Añadir nuevo tipo de notificación
1. Crear `WhatsAppNotificationAdapter` implementando `NotificationPort`
2. Anotar con `@Component("whatsappNotificationAdapter")`
3. Probar con: `POST /api/notifications` con `type: "WHATSAPP"`

### Ejercicio 2: Extender reportes
1. Crear método `generateProductReport` en `GenerateReportUseCase`
2. Añadir endpoint en `ReportController`
3. Probar generación de reporte de productos

### Ejercicio 3: Validaciones avanzadas
1. Añadir validación de formato de email más robusta
2. Añadir validación de número de teléfono
3. Testear casos edge

---

## 📚 Recursos Adicionales

- **Documentación Spring Boot**: https://spring.io/projects/spring-boot
- **Principios SOLID**: https://en.wikipedia.org/wiki/SOLID
- **Clean Architecture**: https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html
- **Gradle User Guide**: https://docs.gradle.org/current/userguide/userguide.html

---

**¡Feliz codificación! 🎉**
