package my.company.core.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
    private final SwaggerProperties swaggerProperties;

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String authServer;

    @Bean
    @ConditionalOnProperty(prefix = "springdoc.api-docs", name = "enabled", havingValue = "true", matchIfMissing = true)
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("spring_oauth", getSecurityScheme())
                        .addParameters("Version", getParameter()))
                .security(getSecurityRequirement())
                .info(getApiInfo());
    }

    private Info getApiInfo() {
        SwaggerProperties.DocApiInfo docApiInfo = swaggerProperties.getDocApiInfo();
        return new Info()
                .title(docApiInfo.getTitle())
                .description(docApiInfo.getDescription())
                .version(docApiInfo.getVersion())
                .license(new License().name(docApiInfo.getLicense().getName()).url(docApiInfo.getLicense().getUrl()))
                .contact(new Contact()
                        .name(docApiInfo.getContact().getName())
                        .email(docApiInfo.getContact().getEmail())
                        .url(docApiInfo.getContact().getUrl()));
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
