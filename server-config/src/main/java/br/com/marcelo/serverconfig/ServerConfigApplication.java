package br.com.marcelo.serverconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication(exclude = {RabbitAutoConfiguration.class})
@EnableConfigServer
public class ServerConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerConfigApplication.class, args);
    }
}
