package my.company.core.exception;

import lombok.RequiredArgsConstructor;
import my.company.util.LogUtil;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;

import static my.company.core.exception.ExceptionType.*;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionsHandler {
    private final ExceptionMessageService exceptionMessageService;
    private static final String DEFAULT_ERROR_CODE = "unknown.error";

    private static final String ROOT_EXCEPTION_PATH = "exception.message";

    @ExceptionHandler(value = {AuthException.class})
    protected ResponseEntity<Object> handleAuthExc(AuthException ex, WebRequest request) {
        ExceptionModel response = new ExceptionModel()
                .setMessage(exceptionMessageService.getMessageException(ROOT_EXCEPTION_PATH, AUTH, ex.getCode()))
                .setCode(ex.getCode())
                .setType(AUTH)
                .setTime(ZonedDateTime.now())
                .setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        LogUtil.INSTANCE.stackTraceLog(ex, 10000);
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = {DataBaseException.class})
    protected ResponseEntity<Object> handleDBExc(DataBaseException ex, WebRequest request) {
        ExceptionModel response = new ExceptionModel()
                .setMessage(exceptionMessageService.getMessageException(ROOT_EXCEPTION_PATH, DB, ex.getCode()))
                .setCode(ex.getCode())
                .setType(DB)
                .setTime(ZonedDateTime.now())
                .setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        LogUtil.INSTANCE.stackTraceLog(ex, 10000);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {ExtException.class})
    protected ResponseEntity<Object> handleExtExc(ExtException ex, WebRequest request) {
        ExceptionModel response = new ExceptionModel()
                .setMessage(exceptionMessageService.getMessageException(ROOT_EXCEPTION_PATH, EXT, ex.getCode()))
                .setCode(ex.getCode())
                .setType(EXT)
                .setTime(ZonedDateTime.now())
                .setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        LogUtil.INSTANCE.stackTraceLog(ex, 10000);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {LogicException.class})
    protected ResponseEntity<Object> handleLogicExc(LogicException ex, WebRequest request) {
        ExceptionModel response = new ExceptionModel()
                .setMessage(exceptionMessageService.getMessageException(ROOT_EXCEPTION_PATH, LOGIC, ex.getCode()))
                .setCode(ex.getCode())
                .setType(LOGIC)
                .setTime(ZonedDateTime.now())
                .setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        LogUtil.INSTANCE.stackTraceLog(ex, 10000);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {FileSystemException.class})
    protected ResponseEntity<Object> handleFileSysExc(FileSystemException ex, WebRequest request) {
        ExceptionModel response = new ExceptionModel()
                .setMessage(exceptionMessageService.getMessageException(ROOT_EXCEPTION_PATH, LOGIC, ex.getCode()))
                .setCode(ex.getCode())
                .setType(IO)
                .setTime(ZonedDateTime.now())
                .setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        LogUtil.INSTANCE.stackTraceLog(ex, 10000);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleDefaultExc(Exception ex, WebRequest request) {
        ExceptionModel response = new ExceptionModel()
                .setMessage(exceptionMessageService.getMessageException(ROOT_EXCEPTION_PATH, GENERAL, DEFAULT_ERROR_CODE))
                .setCode(DEFAULT_ERROR_CODE)
                .setType(GENERAL)
                .setTime(ZonedDateTime.now())
                .setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        LogUtil.INSTANCE.stackTraceLog(ex, 10000);
        MDC.put("Response_Marker", "pipe.unsucc");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
