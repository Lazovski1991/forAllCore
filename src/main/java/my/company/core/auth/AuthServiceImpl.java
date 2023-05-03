package my.company.core.auth;

import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AuthServiceImpl implements AuthService {
    @Override
    public AuthUser getUserPrincipal(Jwt jwt) {
        Map<String, Object> claims = jwt.getClaims();

        return new AuthUser()
                .setUserId(getClaimValue("sub", claims))
                .setUsername(getClaimValue("preferred_username", claims))
                .setEmail(getClaimValue("email", claims))
                .setCustomAttributes(getCustomAttributes(claims));
    }

    private HashMap<String, String> getCustomAttributes(Map<String, Object> claims) {
        HashMap<String, String> map = new HashMap<>();
        Arrays.stream(CustomAttributesType.values())
                .forEach((type) -> map.put(type.getName(), getClaimValue(type.getName(), claims)));

        return map;
    }

    private String getClaimValue(String claimName, Map<String, Object> claims) {
        return claims.get(claimName) != null ? (String) claims.get(claimName) : null;
    }
}
