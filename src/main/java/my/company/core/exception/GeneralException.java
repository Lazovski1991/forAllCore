package my.company.core.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Default Exception that throw
 */
@Getter
@Setter
public class GeneralException extends RuntimeException {
    private String code;

    public GeneralException(String message) {
        super(message);
    }

    public GeneralException(Throwable e, String message) {
        super(message, e);
    }

    public GeneralException(Throwable e, String message, String code) {
        super(message, e);
        this.code = code;
    }

    public GeneralException(String message, String code) {
        super(message);
        this.code = code;
    }
}
