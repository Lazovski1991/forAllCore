package my.company.core.exception;

/**
 * Exception that throw when authentication fails
 */
public class AuthException extends GeneralException {
    public AuthException(String message) {
        super(message);
    }

    public AuthException(Throwable e, String message) {
        super(e, message);
    }

    public AuthException(Throwable e, String message, String code) {
        super(e, message, code);
    }

    public AuthException(String message, String code) {
        super(message, code);
    }
}
