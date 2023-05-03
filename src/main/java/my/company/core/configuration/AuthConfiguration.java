package my.company.core.configuration;

import my.company.core.auth.AuthService;
import my.company.core.auth.AuthServiceImpl;
import my.company.core.auth.JwtAuthConverter;
import my.company.core.auth.JwtAuthConverterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JwtAuthConverterProperties.class)
public class AuthConfiguration {
    @Bean
    public JwtAuthConverter jwtAuthConverter(@Autowired AuthService authService,
                                             @Autowired JwtAuthConverterProperties properties) {
        return new JwtAuthConverter(authService, properties);
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthService createAuthService() {
        return new AuthServiceImpl();
    }
}
