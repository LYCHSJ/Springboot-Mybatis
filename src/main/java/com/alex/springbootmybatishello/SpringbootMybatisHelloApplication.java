package com.alex.springbootmybatishello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.alex.springbootmybatishello.mapper")
public class SpringbootMybatisHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisHelloApplication.class, args);
    }
}
