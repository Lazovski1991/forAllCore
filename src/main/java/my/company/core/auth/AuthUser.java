package my.company.core.auth;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
public class AuthUser {
    private String userId;
    private String username;
    private String email;
    private List<String> roles;
    private Map<String, String> customAttributes;
}
