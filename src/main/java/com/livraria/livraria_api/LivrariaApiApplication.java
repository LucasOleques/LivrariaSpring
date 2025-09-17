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
http://localhost:8080/api/v1/livro

{
	"titulo": "titulo livro teste",
    "local_estoque": "prateleira",
    "quantidade_estoque": "10",
    "isbn": "0321765723",
    "autor" : {
        "nome_autor": "autor livro",
        "idade_autor": "30"
    }
}


978-0-306-40615-7		ISBN-13 válido com hifens.
0321765723		        ISBN-10 válido sem separadores.
ISBN 0-306-40615-2		ISBN-10 com prefixo "ISBN" e espaços.
9780306406157		    ISBN-13 válido sem separadores.
978 3 16 148410 0		ISBN-13 com espaços.
*/