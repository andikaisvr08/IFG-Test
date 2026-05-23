# IFGTest-API

Katalon Studio project for REST API and Kafka testing.

## Test Cases

- **TC01** - GET all posts (consumer)
- **TC02** - GET single post + negative test 404 (consumer)
- **TC03** - POST create post (producer)
- **TC04** - POST empty body / negative test (producer)
- **TC05** - Using Katalon built-in WS keywords + Object Repository
- **TC06** - Kafka consumer (subscribe & consume messages)

## How to Run

- REST API (TC01-TC05): Run in Katalon Studio, no setup needed.
- Kafka (TC06): Need Docker first. Run `docker-compose up -d`

## API Target

- REST: https://jsonplaceholder.typicode.com
- Kafka: localhost:9092

## Folder

- `Scripts/` - test scripts
- `Object Repository/` - WS request objects (for TC05)
- `Drivers/` - kafka JAR
- `evidence/` - screenshot test results
- `docker-compose.yml` - kafka setup
