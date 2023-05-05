package my.company.core.configuration;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "springdoc")
@Data
@Accessors(chain = true)
public class SwaggerProperties {
    private String enabled;
    private String packagesToScan;
    private SwaggerUi swaggerUi = new SwaggerUi();
    private DocApiInfo docApiInfo = new DocApiInfo();

    @Data
    @Accessors(chain = true)
    public static class SwaggerUi {
        private String path;
    }

    @Data
    @Accessors(chain = true)
    public static class DocApiInfo {
        private String title = "Tittle";
        private String description = "Description";
        private String version = "Version";
        private License license = new License();
        private Contact contact = new Contact();
    }

    @Data
    @Accessors(chain = true)
    public static class License {
        private String name = "License";
        private String url = "http://url.example.ru";
    }

    @Data
    @Accessors(chain = true)
    public static class Contact {
        private String name = "ContactName";
        private String email = "ContactEmail";
        private String url = "ContactUrl";
    }
}