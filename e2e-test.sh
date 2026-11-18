#!/usr/bin/env bash
set -euo pipefail
base=${BASE_URL:-http://localhost:3000}
curl -fsS "$base/" | grep -q '<title>CRM'
curl -fsS "$base/api/customers" >/dev/null
curl -fsS "$base/api/deals" >/dev/null
curl -fsS "$base/api/tasks" >/dev/null
echo 'e2e smoke passed'
