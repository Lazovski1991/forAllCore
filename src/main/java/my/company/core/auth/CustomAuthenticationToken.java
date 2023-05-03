package my.company.core.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;

public class CustomAuthenticationToken extends AbstractAuthenticationToken {
    private final Jwt jwt;
    private final AuthUser user;

    public CustomAuthenticationToken(Jwt jwt, Collection<? extends GrantedAuthority> authorities, AuthUser user) {
        super(authorities);
        this.jwt = jwt;
        this.user = user;
    }

    @Override
    public Object getCredentials() {
        return jwt;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }
}
