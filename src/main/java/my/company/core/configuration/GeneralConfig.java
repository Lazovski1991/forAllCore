package my.company.core.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class GeneralConfig {
    @Value("${cors.allowedOrigins:}#{T(java.util.Collections).emptyList()}")
    private List<String> allowedOrigins;
    @Bean
    @ConditionalOnProperty(prefix = "cors", name = "enabled", havingValue = "false", matchIfMissing = false)
    public WebMvcConfigurer configure() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                allowedOrigins
                        .forEach(alOr -> registry.addMapping("/**")
                                .allowedOrigins(alOr)
                                .allowedMethods("GET", "POST","PUT", "DELETE"));
            }
        };
    }

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("Date in UTC: " + LocalDateTime.now());
    }
}
