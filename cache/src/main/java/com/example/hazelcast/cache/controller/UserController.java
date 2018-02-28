package com.example.hazelcast.cache.controller;

import com.example.hazelcast.cache.model.User;
import com.example.hazelcast.cache.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userRepository.findOne(id);
    }

    @GetMapping("/age/{age}")
    public List<User> getByAge(@PathVariable int age) {
        return userRepository.findByAge(age);
    }

    @GetMapping("/setup")
    public Iterable<User> setup() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("Marcelo");
        user1.setAge(22);
        User user2 = new User();
        user2.setName("Everton");
        user2.setAge(30);
        User user3 = new User();
        user3.setName("André");
        user3.setAge(33);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return userRepository.save(users);
    }

}
