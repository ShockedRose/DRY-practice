package com.ejercicio.infrastructure.adapter.input.rest;

import com.ejercicio.application.dto.NotificationDTO;
import com.ejercicio.application.usecase.SendNotificationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * Controlador REST para notificaciones
 * SOLID - SRP: Solo maneja requests HTTP de notificaciones
 * SOLID - DIP: Depende del caso de uso (abstracción)
 * DRY: No duplica validaciones ni lógica de negocio
 */
@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final SendNotificationUseCase sendNotificationUseCase;

    /**
     * Envía una notificación
     * DRY: Validación y lógica en el caso de uso
     */
    @PostMapping
    public ResponseEntity<String> sendNotification(@Valid @RequestBody NotificationDTO notificationDTO) {
        sendNotificationUseCase.sendNotification(notificationDTO);
        return ResponseEntity.ok("Notification sent successfully");
    }

    /**
     * Endpoint de conveniencia para email
     * DRY: Reutiliza el endpoint principal
     */
    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String message) {
        
        NotificationDTO dto = NotificationDTO.builder()
                .recipient(to)
                .subject(subject)
                .message(message)
                .type("EMAIL")
                .build();
        
        return sendNotification(dto);
    }

    /**
     * Endpoint de conveniencia para SMS
     */
    @PostMapping("/sms")
    public ResponseEntity<String> sendSms(
            @RequestParam String phone,
            @RequestParam String message) {
        
        NotificationDTO dto = NotificationDTO.builder()
                .recipient(phone)
                .message(message)
                .type("SMS")
                .build();
        
        return sendNotification(dto);
    }

    /**
     * Endpoint de conveniencia para Push
     */
    @PostMapping("/push")
    public ResponseEntity<String> sendPush(
            @RequestParam String deviceToken,
            @RequestParam String message) {
        
        NotificationDTO dto = NotificationDTO.builder()
                .recipient(deviceToken)
                .message(message)
                .type("PUSH")
                .build();
        
        return sendNotification(dto);
    }
}
