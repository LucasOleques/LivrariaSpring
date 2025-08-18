package com.livraria.livraria_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApiApplication.class, args);
	}
}

/*

No terminal:  mvn spring-boot:run
http://localhost:8081/api/v1/livro

{
	"titulo": "titulo livro teste",
    "local_estoque": "prateleira",
    "quantidade_estoque": "10",
    "autor" : {
        "nome_autor": "autor livro",
        "idade_autor": "30"
    }
}
*/