FROM adoptopenjdk/openjdk11:latest

ADD ./target/redis-service-web-1.0-SNAPSHOT-exec.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/redis-service-web-1.0-SNAPSHOT-exec.jar", "--spring.redis.host=service-redis"]

EXPOSE 8080