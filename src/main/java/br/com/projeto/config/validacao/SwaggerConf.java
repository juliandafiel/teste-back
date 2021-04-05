package br.com.projeto.config.validacao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.projeto.modelo.Usuario;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConf {
	
	 @Bean
	 public Docket appApi() {
		 return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("br.com.projeto"))
				 .paths(PathSelectors.ant("/**"))
				 .build()
				 .ignoredParameterTypes(Usuario.class);
	 }

}
