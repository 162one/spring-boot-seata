package com.seata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.seata.mapper")
public class SpringBootSeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSeataApplication.class, args);
    }

}
