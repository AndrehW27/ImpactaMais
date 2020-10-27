package com.zeroseis.impactamais.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)

				.select().apis(RequestHandlerSelectors.basePackage("com.zeroseis.impactamais.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Impacta+").description("Projeto integrador - Generation Brasil").version("1.0")
				.contact(contact()).build();

	}

	private Contact contact() {
		return new Contact	("- André Willian\n- Carolina Mira\n- Jéssica Lorena\n- Mauricio Coutinho","https://github.com/AndrehW27/ImpactaMais", 
                "Desenvolvedores em desenvolvimento");

	}
}
