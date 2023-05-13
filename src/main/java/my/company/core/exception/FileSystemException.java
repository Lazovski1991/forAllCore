package my.company.core.exception;

/**
 * Exception that throw when error IO
 */
public class FileSystemException extends GeneralException{
    public FileSystemException(String message) {
        super(message);
    }

    public FileSystemException(Throwable e, String message) {
        super(e, message);
    }

    public FileSystemException(Throwable e, String message, String code) {
        super(e, message, code);
    }

    public FileSystemException(String message, String code) {
        super(message, code);
    }
}
