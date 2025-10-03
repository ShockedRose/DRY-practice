package com.ejercicio.infrastructure.adapter.output.notification;

import com.ejercicio.domain.port.output.NotificationPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Adaptador para enviar notificaciones por email
 * SOLID - SRP: Solo maneja envío de emails
 * SOLID - DIP: Implementa la abstracción NotificationPort del dominio
 * SOLID - OCP: Permite añadir nuevos adaptadores sin modificar código existente
 * DRY: Validación heredada del caso de uso
 */
@Slf4j
@Component("emailNotificationAdapter")
public class EmailNotificationAdapter implements NotificationPort {

    /**
     * Envía email
     * En un sistema real, esto integraría con un servicio como SendGrid, AWS SES, etc.
     */
    @Override
    public void send(String recipient, String message) {
        log.info("Sending email to: {}", recipient);
        log.info("Message: {}", message);
        System.out.println("✉️ Email sent to: " + recipient);
        System.out.println("Message: " + message);
    }
}
