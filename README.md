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

## Environment and authentication

Скопируйте шаблон переменных и замените все значения секретов:

```bash
cp .env.example .env
```

`JWT_SECRET` должен быть случайной строкой длиной не менее 32 символов. Переменные `SEED_*` задают тестовые аккаунты, которые создаются только при пустой таблице пользователей. После изменения credentials существующую базу можно пересоздать командой `docker compose down -v` (это удалит локальные данные).

Запуск:

```bash
docker compose up --build
```

Проверка auth flow в запущенном Compose:

```bash
./e2e-auth-test.sh
```

Регистрация нового пользователя всегда создаёт роль `CLIENT`:

```bash
curl -X POST http://localhost:8080/api/auth/register \\
  -H 'Content-Type: application/json' \\
  -d '{"username":"new-client","password":"strong-password"}'
```

Seed-аккаунты для проверки ролей берутся из `.env`: `SEED_CLIENT_*`, `SEED_OPERATOR_*`, `SEED_ADMIN_*`.

## Service layout

Backend is organized under `services/`: `crm-service` is the running transitional API, while `auth-service`, `customer-service`, `sales-service` and `task-service` have independent `pom.xml` and `src` roots and are ready to receive their bounded contexts incrementally. PostgreSQL remains the source of truth; Redis is reserved for cache/session data and Kafka is the event backbone.

RabbitMQ is not used in the current stack. Kafka is preferable here because CRM events (deal changes, task events, audit records) benefit from durable topics, consumer groups and replay. Redis handles low-latency cache and short-lived data; PostgreSQL owns transactional CRM data.

### Frontend login accounts

Для локального входа через `http://localhost:3000` используйте seed-аккаунты из `.env`:

| Роль | Логин | Пароль |
|---|---|---|
| Клиент | `client` | значение `SEED_CLIENT_PASSWORD` |
| Оператор | `operator` | значение `SEED_OPERATOR_PASSWORD` |
| Администратор | `admin` | значение `SEED_ADMIN_PASSWORD` |

Форма логина и регистрации показывается только на auth-экране. После успешного входа она полностью размонтируется; в рабочем интерфейсе остаётся только кнопка выхода.
