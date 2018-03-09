package com.example.refresh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.example.refresh.*"})
public class RefreshApplication {

    public static void main(String[] args) {
        SpringApplication.run(RefreshApplication.class, args);
    }
}
