package com.example.cache.ehcache.repository;

import com.example.cache.ehcache.model.Foo;
import org.springframework.data.repository.CrudRepository;

public interface FooRepository extends CrudRepository<Foo, Long> {
}
