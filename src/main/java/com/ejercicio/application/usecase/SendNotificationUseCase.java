package com.ejercicio.application.usecase;

import com.ejercicio.application.dto.NotificationDTO;
import com.ejercicio.domain.port.output.NotificationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Caso de uso para enviar notificaciones
 * SOLID - SRP: Solo coordina el envío de notificaciones
 * SOLID - OCP: Abierto a extensión (nuevos tipos de notificación) cerrado a modificación
 * SOLID - DIP: Depende de NotificationPort (abstracción)
 * DRY: Centraliza validación y lógica de envío
 */
@Service
@RequiredArgsConstructor
public class SendNotificationUseCase {

    // DRY: Inyección de múltiples implementaciones de NotificationPort
    // Spring inyecta todas las implementaciones disponibles
    private final Map<String, NotificationPort> notificationPorts;

    /**
     * Envía notificación usando el tipo especificado
     * DRY: Validación centralizada y estrategia de envío
     * SOLID - OCP: Añadir nuevos tipos de notificación no requiere modificar este código
     */
    public void sendNotification(NotificationDTO notificationDTO) {
        // DRY: Validación centralizada
        if (!isValidRecipient(notificationDTO.getRecipient())) {
            throw new IllegalArgumentException("Invalid recipient");
        }

        String portKey = notificationDTO.getType().toLowerCase() + "NotificationAdapter";
        NotificationPort notificationPort = notificationPorts.get(portKey);

        if (notificationPort == null) {
            throw new IllegalArgumentException("Unsupported notification type: " + notificationDTO.getType());
        }

        // DRY: Construcción del mensaje centralizada
        String message = buildMessage(notificationDTO);
        notificationPort.send(notificationDTO.getRecipient(), message);
    }

    /**
     * DRY: Validación reutilizable de destinatario
     */
    private boolean isValidRecipient(String recipient) {
        return recipient != null && !recipient.trim().isEmpty();
    }

    /**
     * DRY: Construcción de mensaje centralizada
     */
    private String buildMessage(NotificationDTO dto) {
        if (dto.getSubject() != null && !dto.getSubject().isEmpty()) {
            return dto.getSubject() + ": " + dto.getMessage();
        }
        return dto.getMessage();
    }
}
