package my.company.core.exception;

/**
 * Exception that throw when database fails
 */
public class DataBaseException extends GeneralException {
    public DataBaseException(String message) {
        super(message);
    }

    public DataBaseException(Throwable e, String message) {
        super(e, message);
    }

    public DataBaseException(Throwable e, String message, String code) {
        super(e, message, code);
    }

    public DataBaseException(String message, String code) {
        super(message, code);
    }
}
