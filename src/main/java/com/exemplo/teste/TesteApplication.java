package com.exemplo.teste;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Product OpenApi", version = "1", description = "API desenvolvida para testes em java OpenApi"))
public class TesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);
	}

}
