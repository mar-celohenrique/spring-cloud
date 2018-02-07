package br.com.marcelo.recommended;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class RecommendedApplication {

    @RequestMapping(value = "/recommended")
    public String readingList() {
        return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
    }

    @RequestMapping(value = "/buy")
    public String buy() {
        return "Java 8 in Action";
    }

    public static void main(String[] args) {
        SpringApplication.run(RecommendedApplication.class, args);
    }
}
