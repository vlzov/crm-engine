#!/usr/bin/env bash
set -euo pipefail
base=${BASE_URL:-http://localhost:8080}
user=${E2E_USERNAME:-operator}; pass=${E2E_PASSWORD:-operator123}
json=$(curl -fsS -X POST "$base/api/auth/login" -H 'Content-Type: application/json' -d "{\"username\":\"$user\",\"password\":\"$pass\"}")
token=$(printf '%s' "$json" | python3 -c 'import json,sys; print(json.load(sys.stdin)["accessToken"])')
refresh=$(printf '%s' "$json" | python3 -c 'import json,sys; print(json.load(sys.stdin)["refreshToken"])')
curl -fsS "$base/api/customers" -H "Authorization: Bearer $token" >/dev/null
next=$(curl -fsS -X POST "$base/api/auth/refresh" -H 'Content-Type: application/json' -d "{\"refreshToken\":\"$refresh\"}")
next_refresh=$(printf '%s' "$next" | python3 -c 'import json,sys; print(json.load(sys.stdin)["refreshToken"])')
curl -fsS -X POST "$base/api/auth/logout" -H 'Content-Type: application/json' -d "{\"refreshToken\":\"$next_refresh\"}" >/dev/null
echo 'auth e2e passed'
