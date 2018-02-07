package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBRemoteConfiguration {

    @Bean(name = "remote")
    public String url() {
        return "bean";
    }

}
