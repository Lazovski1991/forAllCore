package my.company.core.exception;

import lombok.Getter;

@Getter
public enum ExceptionType {
    AUTH("auth"),
    DB("db"),
    EXT("ext"),
    LOGIC("logic"),
    GENERAL("general");

    private String type;

    ExceptionType(String type) {
        this.type = type;
    }
}
