# Spring Boot Microservices Template

## Stack

- Java 21
- Maven (multi-module)
- Spring Boot 3
- PostgreSQL
- Lombok + MapStruct
- Shared Kotlin library

## Modules

- `shared-kotlin-lib` (Kotlin shared code)
- `inventory-service` (port `8081`)
- `billing-service` (port `8082`)

## QuickStart

1. Open in Dev Container.
2. Build once (Optional):
   ```bash
   mvn -DskipTests compile
   ```
3. Run both services (VS Code):
   - Run/Debug -> `Spring Boot-Run Both Microservices`

## URLs

- Inventory: `http://localhost:8081`
- Billing: `http://localhost:8082`
- Actuator: `/actuator/health`

## Live Reload

- Edit code.
- Save file (Optional).
- VS Code auto-builds.
- DevTools restarts service.

Notes:

- Works for both services.
- For shared Kotlin changes, recompile:
  ```bash
  mvn -pl shared-kotlin-lib -am compile
  ```

## Useful Commands

```bash
mvn -DskipTests compile
mvn test
mvn verify
```
