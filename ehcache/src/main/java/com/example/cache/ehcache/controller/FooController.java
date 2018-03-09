package com.example.cache.ehcache.controller;

import com.example.cache.ehcache.model.Foo;
import com.example.cache.ehcache.repository.FooRepository;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/foo")
public class FooController {

    @Autowired
    private FooRepository fooRepository;

    @GetMapping("/setup")
    public Foo setup() {
        Foo foo = new Foo();
        foo.setName("Foo");
        return fooRepository.save(foo);
    }

    @GetMapping("/cache")
    public Optional<Foo> cache() {
        return fooRepository.findById(1l);
    }

    @GetMapping("/enable")
    public int enable() {
        return CacheManager.ALL_CACHE_MANAGERS.get(0)
                .getCache("com.example.cache.ehcache.model.Foo").getSize();
    }

}
