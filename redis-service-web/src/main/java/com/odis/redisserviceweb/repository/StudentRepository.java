package com.odis.redisserviceweb.repository;

import com.odis.redisserviceweb.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

    List<Student> findAllByName(String name);

    List<Student> findAllByNameAndAge(String name, int age);

}
