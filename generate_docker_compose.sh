#!/bin/bash

cat <<EOF > docker-compose.yml
version: "3.9"
services:
  aigineer-back:
    build:
      dockerfile: ./Dockerfile
    hostname: aigineer-back
    ports:
      - "8080:8080"
    environment:
      - DB_URI=jdbc:postgresql://aigineer_psql:5432/aigineer_db
      - DB_USR=postgres
      - DB_PASS=postgres
      - GIGA_CHAT_AUTH_TOKEN=${GIGA_CHAT_AUTH_TOKEN}
    networks:
      - common-network
    depends_on:
      - postgres

  postgres:
    image: postgres:13.3
    environment:
      POSTGRES_DB: "postgres"
      POSTGRES_USER: "postgres"
      POSTGRES_PASSWORD: "postgres"
    hostname: aigineer_psql
    volumes:
      - ./database-scripts/init:/docker-entrypoint-initdb.d
    ports:
      - "6432:5432"
    networks:
      - common-network

  node_exporter:
    image: prom/node-exporter:latest
    ports:
      - "9100:9100"
    networks:
      - common-network

  prometheus:
    image: prom/prometheus:latest
    ports:
      - "9090:9090"
    volumes:
      - ./prometheus.yml:/etc/prometheus/prometheus.yml
    command:
      - '--config.file=/etc/prometheus/prometheus.yml'
    networks:
      - common-network

  grafana:
    image: grafana/grafana:latest
    ports:
      - "3000:3000"
    networks:
      - common-network
    environment:
      - GF_SECURITY_ADMIN_PASSWORD=admin
    depends_on:
      - prometheus

networks:
  common-network:
    driver: bridge
EOF

echo "docker-compose.yml has been generated."
