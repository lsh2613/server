package com.pitchain.common.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI pitchainOpenAPI() {
        return new OpenAPI()
                // swagger에서 jwt 활용하기 위한 설정
//                .components(new Components()
//                        .addSecuritySchemes(
//                                AUTHORIZATION,
//                                new SecurityScheme()
//                                        .name(AUTHORIZATION)
//                                        .type(HTTP)
//                                        .scheme("Bearer")
//                                        .bearerFormat(JWT))
//                )
//                .addSecurityItem(new SecurityRequirement().addList(AUTHORIZATION))
                .externalDocs(new ExternalDocumentation()
                        .description("Pitchain Server Github")
                        .url("https://github.com/Young-Flow/server"))
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Pitchain API")
                .version("v0.0.1");
    }

}
