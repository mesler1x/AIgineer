#!/bin/bash

chmod +x ./generate_prometheus.sh
chmod +x ./generate_docker_compose.sh

echo "Запуск генерации prometheus.yml..."
sudo ./generate_prometheus.sh

echo "Запуск генерации docker-compose.yml..."
sudo ./generate_docker_compose.sh

echo "Оба файла успешно сгенерированы."
