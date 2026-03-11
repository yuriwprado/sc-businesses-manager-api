# SC Businesses Manager API

CRUD REST API for managing businesses in the state of Santa Catarina
---

## Tech Stack

- Java 21
- Spring Boot 4.0.3
- Spring Data JPA
- Spring Validation
- PostgreSQL 16
- Flyway (migrations)
- Lombok
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

## Environment Variables

| Variable      | Default        | Description         |
|---------------|----------------|---------------------|
| `DB_HOST`     | `localhost`    | PostgreSQL host     |
| `DB_PORT`     | `5432`         | PostgreSQL port     |
| `DB_NAME`     | `sc_businesses`| Database name       |
| `DB_USER`     | `sc_user`      | Database user       |
| `DB_PASSWORD` | `sc_pass`      | Database password   |
| `SERVER_PORT` | `8080`         | Application port    |
