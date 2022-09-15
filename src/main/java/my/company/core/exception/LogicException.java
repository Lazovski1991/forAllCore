package my.company.core.exception;

/**
 * Exception that throw when  user's actions no correct or forbidden
 */
public class LogicException extends GeneralException{
    public LogicException(String message) {
        super(message);
    }

    public LogicException(Throwable e, String message) {
        super(e, message);
    }

    public LogicException(Throwable e, String message, String code) {
        super(e, message, code);
    }

    public LogicException(String message, String code) {
        super(message, code);
    }
}
