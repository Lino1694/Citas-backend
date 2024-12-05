# Proyecto de Gestión de Citas

## Requisitos
- Java 17
- Maven
- MySQL

## Configuración de MySQL
1. Crear una base de datos `backcitas`.
2. Configurar las credenciales en `application.properties`.


## Pruebas de postman
POST http://localhost:8080/api/usuarios
GET http://localhost:8080/api/usuarios
ELETE http://localhost:8080/api/usuarios/{id}
POST http://localhost:8080/api/citas
POST http://localhost:8080/api/citas/asignar/{id}
POST http://localhost:8080/api/citas/completar/{id}
POST http://localhost:8080/api/citas/reabrir/{id}
GET http://localhost:8080/api/citas


```properties
spring.datasource.url=jdbc:mysql://localhost:3306/backcitas
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update


