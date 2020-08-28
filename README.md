# spring-data-redis

### Run project in docker container:
```
mvn clean install
docker compose build
docker compose up
```

### Monitor Redis requests: 
```
docker exec -it spring-data-redis_service-redis_1 bash
redis-cli
monitor
```

Run application: [Localhost](https://localhost:8080)