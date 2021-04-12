package com.codeacademyfinalproject.personalworkoutapp.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfiguration {
	
	@Bean
	public GroupedOpenApi adminApi() {
		return GroupedOpenApi.builder()
				.group("api-admin")
				.pathsToMatch("/admin/**")
				.build();
	}
	
	@Bean 
	public OpenAPI personalWorkoutApp() {
		return new OpenAPI()
				.info(new Info().title("Personal Workout App")
				.description("Demo sample application")
	            .version("v0.0.1")
	            .license(new License().name("Apache 2.0").url("http://springdoc.org")))
	            .externalDocs(new ExternalDocumentation());
	}
	
}
