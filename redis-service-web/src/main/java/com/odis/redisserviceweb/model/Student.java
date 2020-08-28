package com.odis.redisserviceweb.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("Student")
public class Student {
    @Id
    private String id;
    private String name;
    private int age;
}
