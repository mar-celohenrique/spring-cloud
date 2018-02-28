package com.example.hazelcast.cache.repository;

import com.example.hazelcast.cache.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Cacheable("findByAge")
    List<User> findByAge(int age);

    @Cacheable("findById")
    @Override
    User findOne(Integer integer);
}
