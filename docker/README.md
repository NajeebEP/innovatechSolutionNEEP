# Innovatech Solutions — Docker Composes

## Archivos disponibles

| Archivo | Contenido | Puerto(s) |
|---|---|---|
| `docker-compose.bdd.yml` | PostgreSQL 16 (3 BDs) | 5432, 5433, 5434 |
| `docker-compose.eureka.yml` | Service Discovery (Eureka) | 8761 |
| `docker-compose.infra.yml` | Keycloak 24 + MailHog | 8080, 1025, 8025 |
| `docker-compose.ms-proyectos.yml` | MS Gestión de Proyectos | 8081 |
| `docker-compose.ms-recursos.yml` | MS Gestión de Recursos | 8082 |
| `docker-compose.ms-analitica.yml` | MS Monitoreo y Analítica | 8083 |
| `docker-compose.bff.yml` | Backend For Frontend | 8084 |
| `docker-compose.gateway.yml` | API Gateway | 9000 |
| `docker-compose.frontend.yml` | Frontend React 18.3 | 3000 |
| `docker-compose.monitoring.yml` | Prometheus + Grafana | 9090, 3001 |

---

## Orden de arranque (IMPORTANTE)

Respetar este orden porque cada servicio depende del anterior:

### Paso 1 — Crear la red compartida (solo la primera vez)
```bash
docker network create innovatech-net
```

### Paso 2 — Bases de datos
```bash
docker compose -f docker-compose.bdd.yml up -d
```

### Paso 3 — Service Discovery
```bash
docker compose -f docker-compose.eureka.yml up -d
```

### Paso 4 — Infraestructura (Keycloak + MailHog)
```bash
docker compose -f docker-compose.infra.yml up -d
```

### Paso 5 — Microservicios (se pueden levantar en paralelo)
```bash
docker compose -f docker-compose.ms-proyectos.yml up -d
docker compose -f docker-compose.ms-recursos.yml up -d
docker compose -f docker-compose.ms-analitica.yml up -d
```

### Paso 6 — BFF
```bash
docker compose -f docker-compose.bff.yml up -d
```

### Paso 7 — API Gateway
```bash
docker compose -f docker-compose.gateway.yml up -d
```

### Paso 8 — Frontend
```bash
docker compose -f docker-compose.frontend.yml up -d
```

### Paso 9 — Monitoreo
```bash
docker compose -f docker-compose.monitoring.yml up -d
```

---

## URLs de acceso

| Servicio | URL |
|---|---|
| Frontend (React) | http://localhost:3000 |
| API Gateway | http://localhost:9000 |
| Eureka (Service Discovery) | http://localhost:8761 |
| Keycloak (Auth) | http://localhost:8080 — admin/admin |
| MailHog (correos) | http://localhost:8025 |
| Prometheus | http://localhost:9090 |
| Grafana | http://localhost:3001 — admin/admin |

---

## Apagar todo
```bash
docker compose -f docker-compose.monitoring.yml down
docker compose -f docker-compose.frontend.yml down
docker compose -f docker-compose.gateway.yml down
docker compose -f docker-compose.bff.yml down
docker compose -f docker-compose.ms-analitica.yml down
docker compose -f docker-compose.ms-recursos.yml down
docker compose -f docker-compose.ms-proyectos.yml down
docker compose -f docker-compose.infra.yml down
docker compose -f docker-compose.eureka.yml down
docker compose -f docker-compose.bdd.yml down
```

## Apagar y eliminar volúmenes (borra los datos)
```bash
docker compose -f docker-compose.bdd.yml down -v
```
