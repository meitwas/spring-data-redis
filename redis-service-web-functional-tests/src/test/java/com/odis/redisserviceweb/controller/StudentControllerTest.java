package com.odis.redisserviceweb.controller;

import com.jayway.restassured.http.ContentType;
import com.odis.redisserviceweb.BaseTest;
import com.odis.redisserviceweb.model.Student;
import com.odis.redisserviceweb.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.jayway.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class StudentControllerTest extends BaseTest {

    private static final Student STUDENT_1 = new Student("1", "Stephen", 48);
    private static final Student STUDENT_2 = new Student("2", "Macaulay", 40);

    @Autowired
    private StudentService studentService;

    @Test
    void shouldReturnStudentById() {
        studentService.save(STUDENT_1);

        var response = given().when()
                .get("/get/1")
                .then().log().all()
                .extract().body()
                .as(Student.class);

        assertThat(response).isEqualTo(STUDENT_1);
    }

    @Test
    void shouldReturnAllStudents() {
        studentService.save(STUDENT_1);
        studentService.save(STUDENT_2);

        var response = given().when()
                .get("/get")
                .then().log().all()
                .extract().body()
                .as(Student[].class);

        assertThat(response).containsExactly(STUDENT_1, STUDENT_2);
    }

    @Test
    void shouldSaveStudent() {
        var response = given().contentType(ContentType.JSON)
                .body(STUDENT_1).when()
                .post("/save")
                .then().log().all()
                .extract().body()
                .as(Student.class);

        assertThat(response).isEqualTo(STUDENT_1);
        assertThat(studentService.find("1")).isEqualTo(STUDENT_1);
    }

    @Test
    void shouldRemoveStudent() {
        studentService.save(STUDENT_1);

        given().when()
                .delete("/delete/1")
                .then().log().all()
                .extract();

        assertThat(studentService.find("1")).isEqualTo(new Student());
    }

}
