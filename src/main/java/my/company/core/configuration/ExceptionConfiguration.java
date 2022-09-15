package my.company.core.configuration;

import my.company.core.exception.ExceptionMessageService;
import my.company.core.exception.ExceptionMessageServiceImpl;
import my.company.core.exception.ExceptionsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ExceptionConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public ExceptionMessageService createExceptionMessage(@Autowired ResourceBundleMessageSource resourceBundleMessageSource) {
        return new ExceptionMessageServiceImpl(resourceBundleMessageSource);
    }

    @Bean
    @ConditionalOnMissingBean
    public ExceptionsHandler createExceptionHandler(@Autowired ExceptionMessageService messageService) {
        return new ExceptionsHandler(messageService);
    }
}
