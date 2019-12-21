package com.mengxuegu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBoot09DataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot09DataJpaApplication.class, args);
    }

}
