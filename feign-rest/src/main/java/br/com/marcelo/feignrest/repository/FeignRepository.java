package br.com.marcelo.feignrest.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("RECOMMENDED")
public interface FeignRepository {

    @GetMapping("/recommended")
    String recommended();

    @GetMapping("/buy")
    String buy();

}
