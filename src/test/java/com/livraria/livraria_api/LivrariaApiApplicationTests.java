package com.livraria.livraria_api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.livraria.livraria_api.entity.Usuario;

@SpringBootTest
class LivrariaApiApplicationTests {

	@Test
	public void criacaoUsuario(){
		Usuario usuario = new Usuario();
		usuario.setUsername("admin");
		usuario.setPassword("admin123");
		usuario.setEmail("admin@example.com");

		assert usuario.getUsername().equals("admin");
		assert usuario.getPassword().equals("admin123");
		assert usuario.getEmail().equals("admin@example.com");
	}
}
