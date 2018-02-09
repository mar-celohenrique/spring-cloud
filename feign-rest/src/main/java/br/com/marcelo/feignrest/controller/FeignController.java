package br.com.marcelo.feignrest.controller;

import br.com.marcelo.feignrest.repository.FeignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FeignController {

    @Autowired
    FeignRepository feignRepository;

    @GetMapping("/buy")
    public String buy() {
        return feignRepository.buy();
    }

}
