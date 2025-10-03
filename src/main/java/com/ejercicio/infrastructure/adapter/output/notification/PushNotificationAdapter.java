package com.ejercicio.infrastructure.adapter.output.notification;

import com.ejercicio.domain.port.output.NotificationPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Adaptador para enviar notificaciones push
 * SOLID - SRP: Solo maneja notificaciones push
 * SOLID - DIP: Implementa NotificationPort
 * SOLID - OCP: Sistema abierto para extensión (añadir más tipos de notificación)
 */
@Slf4j
@Component("pushNotificationAdapter")
public class PushNotificationAdapter implements NotificationPort {

    /**
     * Envía notificación push
     * En un sistema real, integraría con Firebase Cloud Messaging, OneSignal, etc.
     */
    @Override
    public void send(String recipient, String message) {
        log.info("Sending Push notification to: {}", recipient);
        log.info("Message: {}", message);
        System.out.println("🔔 Push notification sent to: " + recipient);
        System.out.println("Message: " + message);
    }
}
