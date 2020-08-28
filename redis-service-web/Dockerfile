FROM adoptopenjdk/openjdk11:latest

ADD ./target/redis-service-web-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/redis-service-web-0.0.1-SNAPSHOT.jar", "--spring.redis.host=service-redis"]

EXPOSE 8080