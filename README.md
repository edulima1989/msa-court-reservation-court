# MSA Court Reservation Court

API Spring Boot para gestión de canchas, deportes y horarios.

## Tecnologías

- Java 21
- Spring Boot
- Spring Data JPA
- Flyway
- PostgreSQL
- SpringDoc OpenAPI

## Migraciones

La base de datos se inicializa automáticamente con Flyway al arrancar la app.

Scripts incluidos:

- `src/main/resources/db/migration/V1__create_schema.sql`
- `src/main/resources/db/migration/V2__insert_initial_data.sql`

## Configuración

La aplicación usa estas variables por defecto:

- `DB_USERNAME=postgres`
- `DB_PASSWORD=mysecretpassword`
- base de datos: `canchas_db`
- puerto: `8081`
- context path: `/courts`

## Ejecutar

```bash
./gradlew bootRun
```

## Probar

```bash
./gradlew test
```

## API

Swagger UI:

- `http://localhost:8081/courts/swagger-ui.html`

OpenAPI:

- `http://localhost:8081/courts/api-docs`
