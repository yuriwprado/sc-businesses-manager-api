# SC Businesses Manager API

CRUD REST API for managing businesses in the state of Santa Catarina
---

## Tech Stack

- Java 21
- Spring Boot 3.4.3
- Spring Data JPA
- Spring Validation
- PostgreSQL 16
- Docker + Docker Compose

---

## Running with Docker

### Start everything (PostgreSQL + API)

```bash
docker compose up --build
```

### Only the database (for local dev)

```bash
docker compose up postgres -d
```

Then run the app locally:
```bash
./mvnw spring-boot:run
```

---

## API Endpoints

Base URL: `http://localhost:8080/api/v1`

| Method   | Endpoint                    | Description                       |
|----------|-----------------------------|-----------------------------------|
| `POST`   | `/businesses`               | Create a business                 |
| `GET`    | `/businesses`               | List all businesses               |
| `GET`    | `/businesses/{id}`          | Find by ID                        |
| `PUT`    | `/businesses/{id}`          | Update a business                 |
| `PATCH`  | `/businesses/{id}/status`   | Change status (activate/deactivate) |
| `DELETE` | `/businesses/{id}`          | Delete a business                 |

---

## Request & Response Examples

### POST /api/v1/businesses

```json
{
  "name": "Caramelo Tech",
  "ownerName": "Maria Oliveira",
  "city": "Florianópolis",
  "segment": "TECHNOLOGY",
  "contact": "maria@techsc.com.br"
}
```

**Response 201:**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "name": "Caramelo Tech",
  "ownerName": "Maria Oliveira",
  "city": "Florianópolis",
  "segment": "TECHNOLOGY",
  "contact": "maria@techsc.com.br",
  "status": "ACTIVE"
}
```

### PATCH /api/v1/businesses/{id}/status

```json
{
  "status": "INACTIVE"
}
```

### PUT /api/v1/businesses

```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "name": "Caramelo Tech Updated",
  "ownerName": "Maria Oliveira",
  "city": "Florianópolis",
  "segment": "TECHNOLOGY",
  "contact": "maria@techsc.com.br"
}
```

---

## Business Segments

| Value         | Description   |
|---------------|---------------|
| `TECHNOLOGY`  | Tecnologia    |
| `COMMERCE`    | Comércio      |
| `INDUSTRY`    | Indústria     |
| `SERVICES`    | Serviços      |
| `AGRIBUSINESS`| Agronegócio   |

---

## Project Structure

```
sc-businesses-manager-api/
├── src/
│   ├── main/
│   │   ├── java/com/yprado/businesses/manager/
│   │   │   ├── ScBusinessesManagerApiApplication.java    # Main Spring Boot application
│   │   │   ├── controller/
│   │   │   │   └── BusinessController.java               # REST API endpoints
│   │   │   ├── dto/
│   │   │   │   ├── BusinessCreateDTO.java                # DTO for business creation
│   │   │   │   ├── BusinessDTO.java                      # DTO for business responses
│   │   │   │   └── BusinessUpdateDTO.java                # DTO for business updates
│   │   │   ├── exception/
│   │   │   │   └── handler/                               # Global exception handlers
│   │   │   ├── mapper/
│   │   │   │   ├── BusinessMapper.java                   # MapStruct mapper interface
│   │   │   │   └── BusinessMapperImpl.java               # Generated mapper implementation
│   │   │   ├── persistence/
│   │   │   │   ├── model/
│   │   │   │   │   └── Business.java                     # JPA entity
│   │   │   │   └── repository/                            # JPA repositories
│   │   │   └── service/
│   │   │       └── BusinessService.java                  # Business logic layer
│   │   └── resources/
│   │       ├── application.yml                           # Main application configuration
│   │       └── db/
│   │           └── changelog/
│   │               ├── db.changelog-master.yaml          # Liquibase master changelog
│   │               └── migrations/                        # SQL migration files
│   │                   ├── 0001-create-business-table.sql
│   │                   └── 0002-insert-businesses.sql
│   └── test/
│       ├── java/com/yprado/businesses/manager/
│       │   └── ScBusinessesManagerApiApplicationTests.java  # Main test class
│       └── resources/
│           └── application-test.yml                       # Test configuration
├── target/                                               # Compiled classes and JAR
├── Dockerfile                                            # Docker image definition
├── docker-compose.yml                                    # Docker Compose configuration
├── pom.xml                                               # Maven project configuration
└── README.md                                             # This file
```

### Architecture Overview

This project follows a **Layered Architecture** pattern:

- **Controller Layer**: Handles HTTP requests and responses (`BusinessController`)
- **Service Layer**: Contains business logic (`BusinessService`)
- **Persistence Layer**: Data access using JPA repositories and entities (`Business`, repositories)
- **DTO Layer**: Data Transfer Objects for API communication (`BusinessDTO`, `BusinessCreateDTO`, `BusinessUpdateDTO`)
- **Mapper Layer**: Object mapping between entities and DTOs using MapStruct (`BusinessMapper`)

---

### Youtube project introduction video
https://www.youtube.com/watch?v=Zzj8n9sXo5I