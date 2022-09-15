package my.company.core.auth;

import lombok.Getter;

/**
 * Custom attributes which we extract from token
 */

@Getter
public enum CustomAttributesType {
    AVATAR("avatar");

    private String name;

    CustomAttributesType(String name) {
        this.name = name;
    }
}
