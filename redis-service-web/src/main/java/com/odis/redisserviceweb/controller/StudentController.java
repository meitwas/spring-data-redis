package com.odis.redisserviceweb.controller;

import com.odis.redisserviceweb.model.Student;
import com.odis.redisserviceweb.service.StudentService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Redis web service REST API"))
@Tag(name = "Student", description="Operations about student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get/{id}")
    @Operation(summary = "Get student by Id")
    public Student find(@PathVariable String id) {
        return studentService.find(id);
    }

    @GetMapping("/get")
    @Operation(summary = "Get all students")
    public Iterable<Student> find() {
        return studentService.findAll();
    }

    @PostMapping("/save")
    @Operation(summary = "Save student")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete student")
    public void delete(@PathVariable String id) {
        studentService.delete(id);
    }
}
