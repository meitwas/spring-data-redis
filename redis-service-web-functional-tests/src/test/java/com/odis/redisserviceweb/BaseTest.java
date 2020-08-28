package com.odis.redisserviceweb;

import com.jayway.restassured.RestAssured;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import redis.embedded.RedisServer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = RedisServiceWebApplication.class)
public abstract class BaseTest {

    private RedisServer redisServer;

    @LocalServerPort
    private int serverPort;

    @BeforeEach
    @SneakyThrows
    public void init() {
        RestAssured.port = serverPort;

        redisServer = new RedisServer(6379);
        redisServer.start();
    }

    @AfterEach
    public void tearDown() {
        redisServer.stop();
    }
}
