package my.company.core.configuration;

import my.company.core.service.LocaleService;
import my.company.core.service.LocaleServiceImpl;
import my.company.core.service.TimeService;
import my.company.core.service.TimeServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public TimeService createTimeService() {
        return new TimeServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public LocaleService createLocaleService() {
        return new LocaleServiceImpl();
    }
}
