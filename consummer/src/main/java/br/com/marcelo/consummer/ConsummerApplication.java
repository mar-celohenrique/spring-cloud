package br.com.marcelo.consummer;

import configuration.DBLocalConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ConsumerService;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableCircuitBreaker
@RestController
@EnableEurekaClient
@ComponentScan(basePackages = {"service.**", "br.com.marcelo.**", "configuration.**"}) //, excludeFilters = {
        //@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = DBLocalConfiguration.class)})
@ImportResource("classpath:applicationContext.xml")
public class ConsummerApplication {


    @Autowired
    ConsumerService consumerService;

    @Autowired
    ProducerService producerService;

    @Autowired
    String url;

    @PostConstruct
    public void setUp() {
        System.out.println("-- " + url);
    }

    @RequestMapping("/to-read")
    public String toRead() {
        return consumerService.readingList();
    }

    @RequestMapping("/to-buy")
    public String toBuy() {
        return consumerService.buy();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsummerApplication.class, args);
    }
}
