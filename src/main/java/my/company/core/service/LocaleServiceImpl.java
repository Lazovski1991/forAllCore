package my.company.core.service;

import my.company.core.model.LanguageType;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class LocaleServiceImpl implements LocaleService {
    @Override
    public LanguageType getLocaleType() {
        String fullLanguage = LocaleContextHolder.getLocale().toString();

        if (fullLanguage.contains("en")) return LanguageType.EN;
        else if (fullLanguage.contains("ru")) return LanguageType.RU;
        else if (fullLanguage.contains("be")) return LanguageType.BE;
        else throw new RuntimeException();
    }

    @Override
    public Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }
}
