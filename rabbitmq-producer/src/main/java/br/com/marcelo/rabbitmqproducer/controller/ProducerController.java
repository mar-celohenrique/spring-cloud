package br.com.marcelo.rabbitmqproducer.controller;

import br.com.marcelo.rabbitmqproducer.configuration.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    Producer producer;

    @RequestMapping("/enviar/{msg}")
    public String sendMensage(@PathVariable("msg") String msg) {
        producer.sendMensage(msg);
        return "Done";
    }

}
