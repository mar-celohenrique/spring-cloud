package br.com.marcelo.sessionredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SessionRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SessionRedisApplication.class, args);
    }
}
