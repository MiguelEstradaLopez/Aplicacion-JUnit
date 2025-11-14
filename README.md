# Spring Boot + JUnit Demo

Repositorio de demostración que muestra cómo crear un proyecto Spring Boot mínimo y escribir pruebas con JUnit 5.

Repositorio original: https://github.com/MiguelEstradaLopez/Aplicacion-JUnit.git

Contacto del autor del repositorio:
- Nombre: Miki
- Email: maestralopez766@gmail.com

Resumen
-------
Este proyecto contiene una pequeña aplicación Spring Boot con un servicio de ejemplo (`CalculatorService`) y pruebas unitarias/integradas que demuestran:

- Pruebas de funcionalidad básica (suma).
- Pruebas de comportamiento en condiciones normales (división).
- Pruebas que verifican manejo de errores (división por cero lanza `ArithmeticException`).

Estructura principal
--------------------

- `pom.xml` - configuración de Maven y dependencias (Spring Boot 2.7.x, JUnit 5 a través de `spring-boot-starter-test`).
- `src/main/java/com/example/junitdemo/JunitDemoApplication.java` - clase principal de Spring Boot.
- `src/main/java/com/example/junitdemo/service/CalculatorService.java` - servicio con métodos `add` y `divide`.
- `src/test/java/com/example/junitdemo/service/CalculatorServiceTest.java` - pruebas con JUnit 5 usando `@SpringBootTest`.

Requisitos
---------

- Java 11 o superior (el `pom.xml` está configurado para Java 11). Si quieres usar Java 17 o superior puedo actualizar el `pom.xml` a Spring Boot 3.x.
- Maven instalado y en PATH.

Cómo ejecutar los tests
-----------------------

Desde la raíz del proyecto:

```bash
cd /home/miki/Junit
mvn test
```

Salida esperada: las pruebas se ejecutan y muestran un resumen similar a "Tests run: 3, Failures: 0, Errors: 0, Skipped: 0" y "BUILD SUCCESS".

Ejecutar la aplicación (opcional)
--------------------------------

Si quieres arrancar la aplicación Spring Boot (no es necesario para ejecutar las pruebas):

```bash
mvn spring-boot:run
```

Descripción corta del código
----------------------------

- `CalculatorService`:
	- `int add(int a, int b)` — devuelve la suma.
	- `double divide(double a, double b)` — devuelve la división; si `b == 0` lanza `ArithmeticException`.

- `CalculatorServiceTest`:
	- `testAdd()` — verifica que `2 + 3 == 5`.
	- `testDivide()` — verifica que `10 / 2 == 5.0`.
	- `testDivideByZeroThrows()` — verifica que dividir por cero lanza `ArithmeticException`.


Buenas prácticas y siguientes pasos sugeridos
------------------------------------------

- Añadir pruebas unitarias puras (sin arrancar el contexto Spring) usando Mockito para acelerar los tests. Se añadieron pruebas unitarias puras (`CalculatorServiceUnitTest`) y tests de controlador con `MockMvc`.
- Añadir un controlador REST y pruebas de integración que verifiquen endpoints HTTP. Se añadió `CalculatorController` y su test con `@WebMvcTest`.
- Migrar a Spring Boot 3.x si prefieres Java 17+ (requiere algunos cambios en dependencias y compatibilidad).
- Añadir integración continua (CI). Se agregó un workflow de GitHub Actions en `.github/workflows/ci.yml` que ejecuta `mvn test` en push y pull request contra `main`.

Licencia
--------

Este repositorio incluye una licencia MIT en el archivo `LICENSE`.

Soporte y contacto
-------------------

Si necesitas cambios o tienes dudas, contacta con Miki en `maestralopez766@gmail.com`.

--
Pequeña nota: este README fue generado/actualizado automáticamente para servir como guía rápida del proyecto y cómo ejecutar las pruebas.
