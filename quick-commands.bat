@echo off
REM Script de Comandos Rápidos - Windows - Ejercicio SOLID & DRY

:menu
cls
echo ============================================================
echo      Proyecto SOLID ^& DRY - Spring Boot Application
echo ============================================================
echo.
echo Selecciona una opcion:
echo.
echo 1) Compilar proyecto (build)
echo 2) Limpiar build (clean)
echo 3) Ejecutar aplicacion (bootRun)
echo 4) Compilar sin tests
echo 5) Ver dependencias
echo 6) Ver tareas disponibles
echo 7) Verificar estructura del proyecto
echo 0) Salir
echo.

set /p option="Opcion: "
echo.

if "%option%"=="1" goto build
if "%option%"=="2" goto clean
if "%option%"=="3" goto run
if "%option%"=="4" goto build_no_tests
if "%option%"=="5" goto dependencies
if "%option%"=="6" goto tasks
if "%option%"=="7" goto structure
if "%option%"=="0" goto exit
goto invalid

:build
echo Compilando proyecto...
gradlew.bat build
goto continue

:clean
echo Limpiando build...
gradlew.bat clean
goto continue

:run
echo Ejecutando aplicacion...
echo La aplicacion estara disponible en: http://localhost:8080
echo.
gradlew.bat bootRun
goto continue

:build_no_tests
echo Compilando sin tests...
gradlew.bat build -x test
goto continue

:dependencies
echo Dependencias del proyecto:
gradlew.bat dependencies
goto continue

:tasks
echo Tareas disponibles:
gradlew.bat tasks
goto continue

:structure
echo Estructura del proyecto:
echo.
dir /B *.md *.gradle
echo.
dir /S /B src\*.java | find /C ".java"
echo archivos Java encontrados
goto continue

:invalid
echo Opcion invalida
goto continue

:continue
echo.
pause
goto menu

:exit
echo Hasta luego!
exit /b 0
