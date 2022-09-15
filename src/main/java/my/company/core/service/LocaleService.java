package my.company.core.service;


import my.company.core.model.LanguageType;

import java.util.Locale;

public interface LocaleService {
    LanguageType getLocaleType();

    Locale getLocale();
}
