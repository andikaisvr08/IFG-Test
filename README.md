# IFGTest-API

Katalon Studio project untuk pengujian REST API dan Kafka Consumer.

## Test Cases

| Test Case | Tipe | Peran Katalon |
|-----------|------|---------------|
| TC01_GET_AllPosts | REST API | Consumer (GET) |
| TC02_GET_SinglePost | REST API | Consumer (GET by ID) |
| TC03_POST_CreatePost | REST API | Producer (POST) |
| TC04_Kafka_ConsumeMessages | Kafka | Consumer |

## Cara Menjalankan

1. Buka project di Katalon Studio
2. REST API: langsung jalankan TC01/TC02/TC03 (tanpa setup)
3. Kafka: jalankan `docker-compose up -d` dulu, lalu jalankan TC04

## Target API

- REST: https://jsonplaceholder.typicode.com
- Kafka: localhost:9092 (via Docker)
