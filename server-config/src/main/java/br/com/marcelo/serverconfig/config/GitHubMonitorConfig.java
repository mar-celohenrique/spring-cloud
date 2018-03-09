package br.com.marcelo.serverconfig.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.config.monitor.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;

@Configuration
@Import(FileMonitorConfiguration.class)
public class GitHubMonitorConfig {

    @Autowired(required = false)
    private List<PropertyPathNotificationExtractor> extractors;

    @Bean
    public PropertyPathEndpoint propertyPathEndpoint() {
        return new PropertyPathEndpoint(new CompositePropertyPathNotificationExtractor(this.extractors));
    }

    @Configuration
    protected static class PropertyPathNotificationExtractorConfiguration {

        @Bean
        @ConditionalOnProperty(value = "spring.cloud.config.server.monitor.github.enabled", havingValue = "true", matchIfMissing = true)
        public GithubPropertyPathNotificationExtractor githubPropertyPathNotificationExtractor() {
            return new GithubPropertyPathNotificationExtractor();
        }

        @Bean
        @ConditionalOnProperty(value = "spring.cloud.config.server.monitor.gitlab.enabled", havingValue = "true", matchIfMissing = true)
        public GitlabPropertyPathNotificationExtractor gitlabPropertyPathNotificationExtractor() {
            return new GitlabPropertyPathNotificationExtractor();
        }

        @Bean
        @ConditionalOnProperty(value = "spring.cloud.config.server.monitor.bitbucket.enabled", havingValue = "true", matchIfMissing = true)
        public BitbucketPropertyPathNotificationExtractor bitbucketPropertyPathNotificationExtractor() {
            return new BitbucketPropertyPathNotificationExtractor();
        }
    }


}
