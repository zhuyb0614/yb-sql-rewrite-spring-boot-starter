package com.github.zhuyb0614;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.github.zhuyb0614.mapper")
public class SqlRewriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlRewriteApplication.class, args);
    }

}