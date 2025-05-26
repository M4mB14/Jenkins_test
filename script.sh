#!/bin/bash

# Запуск контейнера alpine в фоне
docker run -d --name my_alpine_test --rm alpine sleep 60

# Пауза на секунду, чтобы контейнер успел стартовать
sleep 1

# Вывод всех запущенных контейнеров
docker ps
