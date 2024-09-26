package br.com.nicola.apigateway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration
{
	@Bean
	public OpenAPI customOpenAPI()
	{
		return new OpenAPI().info( new io.swagger.v3.oas.models.info.Info().title( "Restful API with Spring" )
				                           .version( "1.0" )
				                           .description( "API Gateway" )
				                           .termsOfService( "http://swagger.io/terms/" )
				                           .license( new License().name( "Apache 2.0" )
						                                     .url( "http://springdoc.org" ) ) );
	}
}
