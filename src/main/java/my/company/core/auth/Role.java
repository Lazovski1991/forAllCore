package my.company.core.auth;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Role {
    USER("user"),
    ADMIN("admin"),
    MAINTAINER("maintainer");

    Role(String role) {
        this.role = role;
    }

    private String role;

    public static Role getRole(String role) {
        return Arrays.stream(Role.values())
                .filter(r -> r.role.equals(role))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unknown role"));
    }
}
