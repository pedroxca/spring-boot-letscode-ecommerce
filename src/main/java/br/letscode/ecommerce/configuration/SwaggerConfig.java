package br.letscode.ecommerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@SecurityScheme(type = SecuritySchemeType.APIKEY, name = "bearer_token", in = SecuritySchemeIn.HEADER, bearerFormat = "Bearer token")
@OpenAPIDefinition(security = {@SecurityRequirement(name = "bearer_token")})
public class SwaggerConfig {

  @Bean
  public OpenAPI springShopOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Eccommerce API")
            .description("Lets Code - Banco do Brasil")
            .version("v0.0.1"));
  }

}
