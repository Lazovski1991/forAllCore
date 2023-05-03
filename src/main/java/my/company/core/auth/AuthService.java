package my.company.core.auth;

import org.springframework.security.oauth2.jwt.Jwt;

public interface AuthService {
    AuthUser getUserPrincipal(Jwt jwt);

}
