package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class DBLocalConfiguration {

    @Bean
    public String url() {
        return "local";
    }

}
