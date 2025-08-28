package com.back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.back.domain.post.post.repository")
@MapperScan("com.back.domain.member.member.repository")
@SpringBootApplication
public class P145171Application {

    public static void main(String[] args) {
        SpringApplication.run(P145171Application.class, args);
    }

}
