package com.ejercicio.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración Web para la aplicación
 * SOLID - SRP: Solo configura aspectos web
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configuración CORS para permitir peticiones desde diferentes orígenes
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}
