package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("remote")
public class DBRemoteConfiguration {

    @Bean
    public String url() {
        return "remote";
    }

}
