package my.company.core.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Value("${springdoc.doc-api-info.title}")
    private String title;
    @Value("${springdoc.doc-api-info.description}")
    private String description;
    @Value("${springdoc.doc-api-info.version}")
    private String version;
    @Value("${springdoc.doc-api-info.license.name}")
    private String licenseName;
    @Value("${springdoc.doc-api-info.license.url}")
    private String licenseUrl;
    @Value("${springdoc.doc-api-info.contact.name}")
    private String contactName;
    @Value("${springdoc.doc-api-info.contact.email}")
    private String contactEmail;
    @Value("${springdoc.doc-api-info.contact.url}")
    private String contactUrl;
    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String authServer;

    @Bean
    @ConditionalOnProperty(prefix = "springdoc", name = "enabled", havingValue = "true", matchIfMissing = false)
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("spring_oauth", getSecurityScheme())
                        .addParameters("Version", getParameter()))
                .security(getSecurityRequirement())
                .info(getApiInfo());
    }

    private Info getApiInfo() {
        return new Info()
                .title(title)
                .description(description)
                .version(version)
                .license(new License().name(licenseName).url(licenseUrl))
                .contact(new Contact()
                        .name(contactName)
                        .email(contactEmail)
                        .url(contactUrl));
    }

    private SecurityScheme getSecurityScheme() {
        String authUrl = authServer + "/protocol/openid-connect";

        return new SecurityScheme()
                .type(SecurityScheme.Type.OAUTH2)
                .description("Oauth2 flow")
                .flows(new OAuthFlows()
                        .authorizationCode(new OAuthFlow()
                                .authorizationUrl(authUrl + "/auth")
                                .refreshUrl(authUrl + "/token")
                                .tokenUrl(authUrl + "/token")
                                .scopes(new Scopes())));
    }

    private Parameter getParameter() {
        return new Parameter()
                .in("header")
                .name("Version")
                .schema(new StringSchema())
                .required(false);
    }

    private List<SecurityRequirement> getSecurityRequirement() {
        return List.of(new SecurityRequirement().addList("spring_oauth"),
                new SecurityRequirement().addList("api_key"));
    }
}
