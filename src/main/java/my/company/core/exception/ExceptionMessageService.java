package my.company.core.exception;

public interface ExceptionMessageService {
    String getMessageException(String rootPathException, ExceptionType typeException, String code);
}
