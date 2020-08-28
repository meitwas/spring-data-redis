package com.odis.redisserviceweb.service;

import com.odis.redisserviceweb.model.Student;
import com.odis.redisserviceweb.repository.StudentRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StudentService {
    private static final Student EMPTY_STUDENT = new Student();

    private final StudentRepository studentRepository;

    public Student find(String id) {
        return studentRepository.findById(id)
                .orElse(EMPTY_STUDENT);
    }

    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void delete(String id) {
        studentRepository.deleteById(id);
    }
}
