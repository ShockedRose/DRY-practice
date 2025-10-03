package com.ejercicio.domain.port.output;

/**
 * Puerto de salida para notificaciones
 * SOLID - ISP (Interface Segregation Principle): Interface pequeña y específica para cada tipo de notificación
 * SOLID - DIP (Dependency Inversion Principle): El dominio depende de abstracciones, no de implementaciones
 * 
 * Esta interfaz permite que diferentes implementaciones de notificación puedan ser intercambiadas
 * sin afectar la lógica del dominio (Patrón Strategy)
 */
public interface NotificationPort {
    /**
     * Envía una notificación con el mensaje especificado
     * @param recipient Destinatario de la notificación
     * @param message Mensaje a enviar
     */
    void send(String recipient, String message);
}
