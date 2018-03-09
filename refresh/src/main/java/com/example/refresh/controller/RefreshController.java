package com.example.refresh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class RefreshController {

    @Value("${example.name:Default}")
    private String name;
    @Value("${example.age:Default}")
    private Integer age;

    @GetMapping("/")
    public String home() {
        return name.concat(" ").concat(String.valueOf(age));
    }


}
