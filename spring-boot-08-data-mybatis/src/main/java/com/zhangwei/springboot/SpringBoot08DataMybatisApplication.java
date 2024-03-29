package com.zhangwei.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zhangwei.springboot.mapper")
@SpringBootApplication
public class SpringBoot08DataMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot08DataMybatisApplication.class, args);
    }

}
