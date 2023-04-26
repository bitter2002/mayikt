package com.mayikt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class MayiktSpringboot02Application {

    public static void main(String[] args) {
        SpringApplication.run(MayiktSpringboot02Application.class, args);
    }

}
