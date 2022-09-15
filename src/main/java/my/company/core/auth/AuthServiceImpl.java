package my.company.core.auth;

import org.keycloak.TokenVerifier;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.common.VerificationException;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static my.company.core.auth.CustomAttributesType.AVATAR;

public class AuthServiceImpl implements AuthService {
    @Override
    public UserPrincipal getUserPrincipal(KeycloakAuthenticationToken principal, Collection<GrantedAuthority> authorities) {
        String token = principal.getAccount().getKeycloakSecurityContext().getTokenString();
        TokenVerifier<AccessToken> accessTokenTokenVerifier = TokenVerifier.create(token, AccessToken.class);

        String userName = null;
        String email = null;
        final Map<String, String> customAttributes = new HashMap<>();

        try {
            AccessToken accessToken = accessTokenTokenVerifier.getToken();

            userName = accessToken.getPreferredUsername();
            email = accessToken.getEmail();
            //getting custom attributes from keyckloak which name in CustomAttributesType
            Map<String, Object> otherClaims = accessTokenTokenVerifier.getToken().getOtherClaims();
            Arrays.stream(CustomAttributesType.values())
                    .forEach(attr -> {
                                if (otherClaims.containsKey(attr.getName())) {
                                    customAttributes.put(attr.getName(), String.valueOf(otherClaims.get(AVATAR.getName())));
                                }
                            }
                    );
        } catch (VerificationException e) {
            return null;
        }
        AuthUser user = new AuthUser()
                .setUserId(principal.getAccount().getPrincipal().getName())
                .setUsername(userName)
                .setEmail(email)
                .setCustomAttributes(customAttributes);

        return new UserPrincipal(user, authorities);
    }
}
