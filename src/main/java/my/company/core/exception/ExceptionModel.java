package my.company.core.exception;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@Accessors(chain = true)
public class ExceptionModel {
    private HttpStatus httpStatus;
    private String message;
    private String code;
    private ExceptionType type;
    private ZonedDateTime time;
}
