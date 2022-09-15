package my.company.core.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@RequiredArgsConstructor
public class ExceptionMessageServiceImpl implements ExceptionMessageService {
    private final ResourceBundleMessageSource messageSource;

    @Override
    public String getMessageException(String rootPathException, ExceptionType typeException, String code) {
        Locale locale = LocaleContextHolder.getLocale();
        String key = String.join(".", rootPathException, typeException.getType(), code);

        return messageSource.getMessage(key, null, locale);
    }
}
