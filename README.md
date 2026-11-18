# CRM MVP

Модульный Spring Boot 3 / Java 21 каркас CRM. Авторизация временно отключена: endpoints доступны без JWT и пользователя.

## Запуск

```bash
docker compose up --build
```

API: `http://localhost:8080`, health: `http://localhost:8080/actuator/health`, RabbitMQ UI: `http://localhost:15672` (`guest`/`guest`).

Основные endpoints: `GET/POST /api/customers`, `GET/POST /api/deals`, `GET/POST /api/tasks`, `POST /api/assistant/chat`.

Следующие шаги: выделить сервисы, добавить события RabbitMQ, audit и вернуть auth через Keycloak/JWT.

## Frontend

Простой интерфейс доступен на `http://localhost:3000`. Nginx проксирует запросы `/api/*` во внутренний контейнер `app`, поэтому браузеру не требуется отдельная настройка CORS.
