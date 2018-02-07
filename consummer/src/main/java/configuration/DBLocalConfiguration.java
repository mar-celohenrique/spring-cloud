package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBLocalConfiguration {

    @Bean(name = "local")
    public String url() {
        return "someDummyBean";
    }

}
