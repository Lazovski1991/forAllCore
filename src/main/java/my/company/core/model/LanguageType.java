package my.company.core.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum LanguageType {
    EN("en", 1),
    RU("ru", 2),
    BE("be", 3);

    @JsonValue
    private final String value;
    private final int priority;

    LanguageType(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public static List<LanguageType> getSortPriorityLanguages() {
        return Arrays.stream(LanguageType.values())
                .sorted(Comparator.comparingInt(LanguageType::getPriority))
                .collect(Collectors.toList());
    }
}