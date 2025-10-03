package com.ejercicio.infrastructure.adapter.output.notification;

import com.ejercicio.domain.port.output.NotificationPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Adaptador para enviar notificaciones por SMS
 * SOLID - SRP: Solo maneja envío de SMS
 * SOLID - DIP: Implementa NotificationPort
 * SOLID - LSP (Liskov Substitution): Puede sustituir a cualquier NotificationPort
 */
@Slf4j
@Component("smsNotificationAdapter")
public class SmsNotificationAdapter implements NotificationPort {

    /**
     * Envía SMS
     * En un sistema real, integraría con Twilio, AWS SNS, etc.
     */
    @Override
    public void send(String recipient, String message) {
        log.info("Sending SMS to: {}", recipient);
        log.info("Message: {}", message);
        System.out.println("📱 SMS sent to: " + recipient);
        System.out.println("Message: " + message);
    }
}
