package com.odis.redisserviceweb.core;

import com.odis.redisserviceweb.BaseTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static com.jayway.restassured.RestAssured.given;

class SwaggerTest extends BaseTest {

    @Value("${springdoc.swagger-ui.path}")
    private String swaggerUrl;

    @Test
    void shouldExposeSwaggerUi() {
        given().when().get(swaggerUrl)
               .then()
               .assertThat()
               .statusCode(HttpStatus.SC_OK);
    }
}
