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

    protected RedisServer redisServer;

    @LocalServerPort
    protected int serverPort;

    @BeforeEach
    @SneakyThrows
    protected void init() {
        RestAssured.port = serverPort;
    }

    @AfterEach
    protected void tearDown() {
    }
}
