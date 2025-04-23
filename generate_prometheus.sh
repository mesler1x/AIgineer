#!/bin/bash

cat <<EOF > prometheus.yml
global:
  scrape_interval: 15s

scrape_configs:
  - job_name: 'aigineer-backend'
    metrics_path: '/actuator/prometheus'
    static_configs:
      - targets: ['aigineer.ru:8080']

  - job_name: 'node_prometheus'
    static_configs:
      - targets: ['localhost:9090','aigineer.ru:9100']

remote_read:
  - url: 'https://monitoring.api.cloud.yandex.net/prometheus/workspaces/monn9v3sbfhcg3egk0va/api/v1/read'
    bearer_token: '${YANDEX_API_KEY}'
    headers:
      X-Lookback-Delta: "5m"
EOF

echo "prometheus.yml has been generated."
