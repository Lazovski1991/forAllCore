package my.company.core.exception;

/**
 * Exception that throw when external system or other microservice fails
 */
public class ExtException extends GeneralException {
    public ExtException(String message) {
        super(message);
    }

    public ExtException(Throwable e, String message) {
        super(e, message);
    }

    public ExtException(Throwable e, String message, String code) {
        super(e, message, code);
    }

    public ExtException(String message, String code) {
        super(message, code);
    }
}
