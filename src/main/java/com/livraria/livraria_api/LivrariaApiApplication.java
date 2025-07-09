package com.livraria.livraria_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApiApplication.class, args);
	}
}

// No terminal:  mvn spring-boot:run
// POST PARA: http://localhost:8081/api/v1/livro
/*{
  "titulo": "tituloteste5",
  "local_estoque": "prateleira5",
  "quantidade_estoque": 15,
  "autor": {
    "nome_autor": "nomeautor5",
    "idade_autor": 20
  }
} */