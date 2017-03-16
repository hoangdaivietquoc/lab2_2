package com.polytech.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by daivietquochoang on 16/03/2017.
 */
@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active","PROD");
        SpringApplication.run(ApplicationStarter.class,args);
    }
}
