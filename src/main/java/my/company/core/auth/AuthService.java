package my.company.core.auth;

import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface AuthService {
    UserPrincipal getUserPrincipal(KeycloakAuthenticationToken principal, Collection<GrantedAuthority> authorities);

}
