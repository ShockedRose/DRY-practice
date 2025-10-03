package com.ejercicio.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para notificaciones
 * DRY: Estructura común para diferentes tipos de notificaciones
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private String recipient;
    private String subject;
    private String message;
    private String type; // EMAIL, SMS, PUSH
}
