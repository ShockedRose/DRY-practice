#!/bin/bash

# 🚀 Script de Comandos Rápidos - Ejercicio SOLID & DRY

echo "╔════════════════════════════════════════════════════════════╗"
echo "║     Proyecto SOLID & DRY - Spring Boot Application        ║"
echo "╚════════════════════════════════════════════════════════════╝"
echo ""

# Función para mostrar menú
show_menu() {
    echo "Selecciona una opción:"
    echo ""
    echo "1) 🏗️  Compilar proyecto (build)"
    echo "2) 🧹  Limpiar build (clean)"
    echo "3) ▶️  Ejecutar aplicación (bootRun)"
    echo "4) 📦  Compilar sin tests"
    echo "5) 🧪  Ejecutar tests"
    echo "6) 📋  Ver dependencias"
    echo "7) 📊  Ver tareas disponibles"
    echo "8) 🔍  Verificar estructura del proyecto"
    echo "9) 📚  Abrir documentación"
    echo "0) 🚪  Salir"
    echo ""
}

# Función para compilar
build_project() {
    echo "📦 Compilando proyecto..."
    ./gradlew build
}

# Función para limpiar
clean_project() {
    echo "🧹 Limpiando build..."
    ./gradlew clean
}

# Función para ejecutar
run_project() {
    echo "▶️  Ejecutando aplicación..."
    echo "La aplicación estará disponible en: http://localhost:8080"
    echo ""
    ./gradlew bootRun
}

# Función para compilar sin tests
build_no_tests() {
    echo "📦 Compilando sin tests..."
    ./gradlew build -x test
}

# Función para ejecutar tests
run_tests() {
    echo "🧪 Ejecutando tests..."
    ./gradlew test
}

# Función para ver dependencias
show_dependencies() {
    echo "📋 Dependencias del proyecto:"
    ./gradlew dependencies
}

# Función para ver tareas
show_tasks() {
    echo "📊 Tareas disponibles:"
    ./gradlew tasks
}

# Función para verificar estructura
check_structure() {
    echo "🔍 Estructura del proyecto:"
    echo ""
    echo "📁 Archivos de configuración:"
    ls -lh build.gradle settings.gradle application.yml 2>/dev/null
    echo ""
    echo "📁 Clases Java:"
    find src -name "*.java" | wc -l
    echo "archivos Java encontrados"
    echo ""
    echo "📁 Documentación:"
    ls -lh *.md
}

# Función para abrir documentación
open_docs() {
    echo "📚 Documentación disponible:"
    echo ""
    echo "1. README.md - Documentación principal"
    echo "2. SOLID_DRY_ANALYSIS.md - Análisis de principios"
    echo "3. USAGE_GUIDE.md - Guía de uso"
    echo "4. EXECUTIVE_SUMMARY.md - Resumen ejecutivo"
    echo ""
    read -p "¿Abrir README.md? (y/n): " answer
    if [ "$answer" = "y" ]; then
        cat README.md
    fi
}

# Loop principal
while true; do
    show_menu
    read -p "Opción: " option
    echo ""
    
    case $option in
        1)
            build_project
            ;;
        2)
            clean_project
            ;;
        3)
            run_project
            ;;
        4)
            build_no_tests
            ;;
        5)
            run_tests
            ;;
        6)
            show_dependencies
            ;;
        7)
            show_tasks
            ;;
        8)
            check_structure
            ;;
        9)
            open_docs
            ;;
        0)
            echo "👋 ¡Hasta luego!"
            exit 0
            ;;
        *)
            echo "❌ Opción inválida"
            ;;
    esac
    
    echo ""
    read -p "Presiona ENTER para continuar..."
    clear
done
