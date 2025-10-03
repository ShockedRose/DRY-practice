# Presentación de Equipo

## Nombre del equipo:
BARF Squad

## Integrantes:
1. Miguel Rosa
2. Francisco Mejia
3. Arely Martinez
4. Brian Puerta

## Descripción breve del enfoque para resolver el reto DRY:
(Ejemplo: Nos enfocamos en identificar patrones comunes y abstraer la lógica repetida en métodos auxiliares...)

## Código refactorizado:

https://github.com/ShockedRose/DRY-practice

## Antes y después:
- **Principales repeticiones encontradas:**
  - **ReportGenerator:** Lógica duplicada para generar reportes de ventas e inventario (iteración, cálculo de suma y promedio, impresión de resultados)
  - **UserManager:** Validación idéntica de nombre y email repetida en los métodos `addUser` y `updateUser`
  - **OrderService:** Lógica de validación y procesamiento de órdenes duplicada entre `processOnlineOrder` y `processInStoreOrder`
  - **NotificationService:** Validación de destinatario nula/vacía repetida en los tres métodos de envío (email, SMS, push)
  - **EmployeePayroll:** Cálculo e impresión de nómina duplicado entre procesamiento mensual y anual
  - **ProductService:** Cálculo de descuento idéntico en `getDiscountedPriceA` y `getDiscountedPriceB`

- **Solución aplicada:**
  - **ReportGenerator:** Extracción del método genérico `generateReport()` que acepta `List<? extends Number>` y etiquetas personalizables
  - **UserManager:** Creación del método `validateUser()` que retorna booleano para validación reutilizable
  - **OrderService:** Implementación del método `processOrder(double total, String orderType)` con tipo de orden parametrizado
  - **NotificationService:** Extracción del método `validateRecipient(String recipient, String errorMessage)` con mensaje de error configurable
  - **EmployeePayroll:** Creación del método `printPayrollSummary()` que centraliza el cálculo y la impresión de nóminas
  - **ProductService:** Extracción del método `applyDiscount()` y creación de la constante `DISCOUNT_RATE` para el porcentaje de descuento

- **Beneficios obtenidos:**
  - Cumplimiento del principio DRY (Don't Repeat Yourself)
  - Reducción significativa de líneas de código duplicado
  - Facilidad de mantenimiento: cambios en un solo lugar
  - Menor probabilidad de errores al actualizar lógica
  - Código más legible y mejor organizado
  - Métodos públicos más concisos y enfocados en su responsabilidad específica
  - Reutilización efectiva mediante métodos privados auxiliares

## Aprendizajes principales:
(Ejemplo: Aprendimos sobre métodos genéricos, reutilización de código, etc.)