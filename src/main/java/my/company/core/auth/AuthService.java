package my.company.core.auth;

import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public interface AuthService {
    AuthUser getUserPrincipal(Jwt jwt, List<String> roles);

}
