package com.courtreservation.court.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI courtReservationOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Court Reservation - Court Catalog API")
            .description("CRUD APIs para catalogo de canchas, deportes y horarios de atencion.")
            .version("v1")
            .contact(new Contact().name("Court Reservation Team"))
            .license(new License().name("Apache 2.0")));
  }
}
