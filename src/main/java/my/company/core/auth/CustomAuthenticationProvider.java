package my.company.core.auth;

import lombok.RequiredArgsConstructor;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final AuthService authService;

    @Override
    public UserPrincipal authenticate(Authentication authentication) throws AuthenticationException {
        KeycloakAuthenticationToken keycloakAuthentication = (KeycloakAuthenticationToken) authentication;

        return authService.getUserPrincipal(keycloakAuthentication, keycloakAuthentication.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(KeycloakAuthenticationToken.class);
    }
}
