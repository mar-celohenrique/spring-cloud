package com.example.cache.ehcache;

import com.example.cache.ehcache.model.Foo;
import com.example.cache.ehcache.repository.FooRepository;
import net.sf.ehcache.CacheManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EhcacheApplicationTests {

    @Autowired
    private FooRepository fooRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void cache() {
        Foo foo = new Foo();
        fooRepository.save(foo);
        fooRepository.findById(foo.getId());
        int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
                .getCache("com.example.cache.ehcache.model.Foo").getSize();
        assertThat(size, greaterThan(0));
    }

}
