package my.company.core.configuration;

import my.company.core.auth.AuthService;
import my.company.core.auth.AuthServiceImpl;
import my.company.core.auth.CustomAuthenticationProvider;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;

@Configuration
public class AuthConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthService createAuthService() {
        return new AuthServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthenticationProvider createAuthProvider(@Autowired AuthService authService) {
       return new CustomAuthenticationProvider(authService);
    }
}
